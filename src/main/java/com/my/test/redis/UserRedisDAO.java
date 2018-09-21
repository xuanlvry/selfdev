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

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOperations;

    public void insert(String key, String value) {
        valueOperations.set(key, value);
    }

    public String query(String key) {
        return valueOperations.get(key);
    }

    public void setValueOperations(ValueOperations<String, String> valueOperations) {
        this.valueOperations = valueOperations;
    }

    public void setSetOperations(SetOperations<String, String> setOperations) {
        this.setOperations = setOperations;
    }

    public void setHashOperations(HashOperations<String, byte[], byte[]> hashOperations) {
        this.hashOperations = hashOperations;
    }

    public void setListOperations(ListOperations<String, String> listOperations) {
        this.listOperations = listOperations;
    }
}
