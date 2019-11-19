package com.sun.dev.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunchengfei on 2019-07-19.
 */
public class WaitNotifyTest2 implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " wait");
            wait();
            System.out.println(Thread.currentThread().getName() + " do something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyTest2 myThread = new WaitNotifyTest2();
        new Thread(myThread, "A1").start();
        new Thread(myThread, "A2").start();
        new Thread(myThread, "A3").start();
        Thread.sleep(1000);
        myThread.lock.notify();
        System.out.println(Thread.currentThread().getName() + " nofify");
    }
}
