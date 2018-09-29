package com.my.test.springbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sunchengfei on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class BeanTest {
    @Test
    public void test() {
        Object object = SpringContextUtil.getBean("myServiceImpl");
        Class<?>[] classs = object.getClass().getInterfaces();
        System.out.println();
    }
}