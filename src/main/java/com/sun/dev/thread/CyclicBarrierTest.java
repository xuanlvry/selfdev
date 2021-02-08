package com.sun.dev.thread;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Chengfei.Sun on 2016/9/8.
 */
public class CyclicBarrierTest implements Runnable {
    private CyclicBarrier barrier;
    private String test;

    public CyclicBarrierTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
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
        new Thread(cyclicBarrierTest, "3号选手").start();
    }
}
