package com.my.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
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

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void redisAtomicLongTest() {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("idGener", redisTemplate.getConnectionFactory());
        System.out.println(redisAtomicLong.get());
        System.out.println(redisAtomicLong.addAndGet(5L));
        System.out.println(redisAtomicLong.get());
        System.out.println(redisAtomicLong.incrementAndGet());
        System.out.println(redisAtomicLong.getAndAdd(2));
    }
}
