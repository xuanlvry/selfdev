package com.sun.dev.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchengfei on 2018/3/16.
 */
public class CountTest {
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        //启动两个线程
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //每个线程让count自增10000次
                    for (int j = 0; j < 100000; j++) {
                        synchronized (CountTest.class) {
                            count.incrementAndGet();
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count=" + count);
    }
}
