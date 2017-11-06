package com.my.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2017/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class TransactionTest {
    @Resource(name = "transactionDemo")
    private IMyService transactionDemo;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(100038);
        userInfo.setName("eeeee");

        transactionDemo.updateUser(userInfo);
    }
}
