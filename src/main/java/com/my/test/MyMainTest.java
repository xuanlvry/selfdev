package com.my.test;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by sunchengfei on 2018/6/5.
 */
public class MyMainTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10);
        rateLimiter.acquire();
    }
}
