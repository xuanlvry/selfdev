package com.my.test.springstransaction;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import com.my.test.dao.mybatis.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by sunchengfei on 2017/11/2.
 */
@Service("transactionDemo")
public class TransactionDemo implements IMyService {
    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public UserInfo selectUser(long id) {
        return null;
    }

    public UserInfo selectUser(String account) {
        return null;
    }

    public void updateUser(final UserInfo userInfo) {
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                userMapper.updateUser(userInfo);
                System.out.print(1 / 0);
                try {

                } catch (Exception ex) {
                    status.setRollbackOnly();
                }
                return true;
            }
        });
    }

    public UserInfo selectBySpringCache(String account) {
        return null;
    }
}
