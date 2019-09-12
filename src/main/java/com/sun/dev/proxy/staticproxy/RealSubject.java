package com.sun.dev.proxy.staticproxy;

/**
 * Created by sunchengfei on 2018/5/25.
 */
public class RealSubject implements ISubject {
    @Override
    public String hello(String str) {
        return "hello: " + str;
    }
}
