package com.sun.dev.proxy.spring;

import com.sun.dev.service.IUserService;
import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2019/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml", "classpath:META-INF/application-dao-context.xml"})
public class Client {
    @Resource(name = "workImplProxy")
    private IWork workImpl;

    @Resource
    IUserService userService;

    @Test
    public void test() {
        workImpl.work();
        workImpl.rest();

        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("tom");
        userService.updateUser(userInfo);
    }
}
