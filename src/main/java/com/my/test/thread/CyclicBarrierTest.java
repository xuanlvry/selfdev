package com.my.test.thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Chengfei.Sun on 2016/9/8.
 */
public class CyclicBarrierTest implements Runnable {
    private CyclicBarrier barrier;

    public CyclicBarrierTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(3));
            System.out.println(Thread.currentThread().getName() + " 执行完毕，等待其他线程...");
            barrier.await(4000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 起跑！");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest(barrier);

        new Thread(cyclicBarrierTest, "1号选手").start();
        new Thread(cyclicBarrierTest, "2号选手").start();
        Thread.sleep(5000);
        new Thread(cyclicBarrierTest, "3号选手").start();
    }
}
