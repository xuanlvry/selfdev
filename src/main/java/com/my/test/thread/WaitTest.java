package com.my.test.thread;

/**
 * @author Chengfei.Sun on 2016/9/7.
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
    }
}
