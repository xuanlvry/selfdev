package com.my.test.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chengfei.Sun on 17/03/03.
 */
public class JavaThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * 创建线程池：核心线程数为2，最大线程数为4，线程池维护线程的空闲时间为3秒
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());

        //向线程池中添加10个任务
        for (int i = 1; i <= 10; i++) {
            try {
                String task = "task@" + i;
                System.out.println(task + " 加入线程池");
                threadPool.execute(new ThreadPoolTask(task));
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程池执行的任务
 */
class ThreadPoolTask implements Runnable {
    private String taskName;

    ThreadPoolTask(String name) {
        this.taskName = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行" + taskName);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕" + taskName);
    }
}
