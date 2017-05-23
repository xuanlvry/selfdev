package com.my.test;

import com.my.test.springaop.proxyfactorybean.IWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class MyMacProTest {
    @Resource(name = "workImplProxy")
    private IWork workImpl;

    @Test
    public void springAOPTest() {
        workImpl.work();
    }
}
