package com.my.test.transaction;

import com.my.test.dao.mybatis.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by sunchengfei on 2018/3/9.
 */
@Service
public class SelectForUpdateTestImpl implements SelectForUpdateTest {
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public void useTransaction() {
        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                userMapper.selectUserByIdForUpdate(17L);
                System.out.println(Thread.currentThread().getName() + "线程已执行select for update");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "线程处理完毕");
                return null;
            }
        });
    }

    @Override
    public void notUseTransaction() {
        userMapper.selectUserByIdForUpdate(17L);
        System.out.println(Thread.currentThread().getName() + "线程已执行select for update");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "线程处理完毕");
    }
}
