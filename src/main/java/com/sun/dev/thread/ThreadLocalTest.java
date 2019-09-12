package com.sun.dev.thread;

/**
 * Created by Chengfei.Sun on 17/04/29.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        threadLocal.set("aa");
        System.out.println(threadLocal.get());
    }
}
