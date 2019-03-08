package com.my.test.proxy.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2019/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
public class Client {
    @Resource(name = "workImplProxy")
    private IWork workImpl; //注意这里注入的bean是workImplProxy

    @Test
    public void test() {
        workImpl.work();
    }
}
