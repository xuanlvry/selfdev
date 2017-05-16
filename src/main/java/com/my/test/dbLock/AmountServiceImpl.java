package com.my.test.dbLock;

import com.my.test.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by Chengfei.Sun on 17/05/05.
 */
@Service
public class AmountServiceImpl implements IAmountService{
    Logger logger = LoggerFactory.getLogger(AmountServiceImpl.class);

    @Autowired
    private DBLockDAO dbLockDAO;

    @Transactional
    public void transfer(String threadName) {
        try {
//            dbLockDAO.begin();
            UserInfo dbUser = dbLockDAO.selectByIdForUpdate(61);
            logger.info(threadName + "：查询userInfo信息amout：" + dbUser.getAmount());
            dbUser.setAmount(dbUser.getAmount().subtract(new BigDecimal("100")));
            dbLockDAO.updateAmount(dbUser);
            logger.info(threadName + "：修改userInfo金额amout为：" + dbUser.getAmount());
//            dbLockDAO.commit();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
