package com.sun.dev.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chengfei.Sun on 2016/9/30.
 */
public class Counter extends Thread{

    static int count = 0;

    public Counter(String name) {
        super(name);
    }

    @Override
    public void run(){
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter t1 = new Counter("t1");
        Counter t2 = new Counter("t2");
        Counter t3 = new Counter("t3");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);
        System.out.println(Counter.count);

        Lock lock = new ReentrantLock();
        try {
            boolean locked = lock.tryLock();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
