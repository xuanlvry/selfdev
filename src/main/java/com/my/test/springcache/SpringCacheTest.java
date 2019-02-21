package com.my.test.springcache;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sunchengfei on 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class SpringCacheTest {
    @Autowired
    private IMyService myServiceImpl;

    @Test
    public void test() {
        for (int i = 0; i < 2; i++) {
            System.out.println("aaaaaaaaaaaaaaaaa");
            UserInfo result = myServiceImpl.selectBySpringCache("tom");
            System.out.println(result.getAccount());
        }
    }
}
