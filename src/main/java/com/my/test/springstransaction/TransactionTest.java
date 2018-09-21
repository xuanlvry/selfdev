package com.my.test.springstransaction;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sunchengfei on 2018/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class TransactionTest {
    @Autowired
    private IMyService myService;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount("909090");
        userInfo.setId(17);
        myService.updateUser(new UserInfo());
    }
}
