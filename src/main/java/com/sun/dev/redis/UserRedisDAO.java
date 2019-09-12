package com.sun.dev.redis;

import org.springframework.stereotype.Repository;

/**
 * @author Chengfei.Sun on 2015/5/27.
 */
@Repository
public class UserRedisDAO {
    public void insert(String key, String value) {
        System.out.println("UserRedisDAO insert..");
    }

    public String query(String key) {
        System.out.println("UserRedisDAO query..");
        return "hello world";
    }
}
