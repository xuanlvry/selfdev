package com.my.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2018/5/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class RedisClient {
    @Resource
    private UserRedisDAO userRedisDAO;

    @Test
    public void test() {
        userRedisDAO.insert("name", "tom");
        System.out.println(userRedisDAO.query("name"));
    }
}
