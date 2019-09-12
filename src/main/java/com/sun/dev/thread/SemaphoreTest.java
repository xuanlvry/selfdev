package com.sun.dev.thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author Chengfei.Sun on 2016/9/8.
 */
public class SemaphoreTest implements Runnable {
    private Semaphore semaphore;

    public SemaphoreTest(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " 占用一个许可，执行任务...");
            Thread.sleep(1000 * (new Random()).nextInt(3));
            System.out.println(Thread.currentThread().getName() + " 完成任务，释放许可...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        SemaphoreTest semaphoreTest = new SemaphoreTest(semaphore);

        new Thread(semaphoreTest, "1号选手").start();
        new Thread(semaphoreTest, "2号选手").start();
        new Thread(semaphoreTest, "3号选手").start();
    }
}
