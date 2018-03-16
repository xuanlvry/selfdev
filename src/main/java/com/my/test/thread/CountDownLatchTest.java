package com.my.test.thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Chengfei.Sun on 2016/9/8.
 */
public class CountDownLatchTest implements Runnable {
    private CountDownLatch countDownLatch;

    public CountDownLatchTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(3));
            System.out.println(Thread.currentThread().getName() + " 执行完毕，等待其他线程...");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest(countDownLatch);

        new Thread(countDownLatchTest, "1号选手").start();
        new Thread(countDownLatchTest, "2号选手").start();
        new Thread(countDownLatchTest, "3号选手").start();

        System.out.println(Thread.currentThread().getName() + "等待所有子线程执行完毕...");
        countDownLatch.await(); //调用await()的线程会被挂起，直到count值为0才继续执行
        System.out.println(Thread.currentThread().getName() + "所有子线程执行完毕...");
        System.out.println(Thread.currentThread().getName() + "继续执行...");
    }
}
