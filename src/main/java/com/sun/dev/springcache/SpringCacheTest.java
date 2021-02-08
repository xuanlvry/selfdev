package com.sun.dev.springcache;

import com.sun.dev.service.IUserService;
import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class SpringCacheTest {
    @Resource
    private IUserService myServiceImpl;

    @Test
    public void test() {
        for (int i = 0; i < 2; i++) {
            System.out.println("aaaaaaaaaaaaaaaaa");
            UserInfo result = myServiceImpl.selectBySpringCache("tom");
            System.out.println(result.getAccount());
        }
    }
}
