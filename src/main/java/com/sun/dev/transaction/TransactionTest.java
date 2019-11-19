package com.sun.dev.transaction;

import com.sun.dev.service.IUserService;
import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2019/08/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class TransactionTest {
    @Resource
    private IUserService userServiceTransactionImpl;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(10);
        userInfo.setName("suntest1");

        userServiceTransactionImpl.updateUser(userInfo);
    }

}
