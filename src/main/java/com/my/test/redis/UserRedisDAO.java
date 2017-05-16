package com.my.test.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chengfei.Sun on 2015/5/27.
 */
@Component
public class UserRedisDAO {

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name="redisTemplate")
    private SetOperations<String, String> setOperations;

    @Resource(name="redisTemplate")
    private HashOperations<String, byte[], byte[]> hashOperations;

    private ListOperations<String, String> listOperations;

    public void insert(){
        valueOperations.set("redis", "sun112");
        setOperations.add("redisset", "1");
    }
}
