package com.sun.dev.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Chengfei.Sun on 17/03/03.
 */
public class JavaThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建线程池：核心线程数为2，最大线程数为4，线程池维护线程的空闲时间为3秒
         */
        ExecutorService executorService = new ThreadPoolExecutor(30, 50, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.CallerRunsPolicy());

        //向线程池中添加10个任务
        for (int i = 0; i < 30; i++) {
            executorService.execute(new ThreadPoolTask(String.valueOf(i)));
        }

        //executorService.shutdown();
    }

    /**
     * 线程池执行的任务
     */
    private static class ThreadPoolTask implements Runnable {
        private String threadName;

        public ThreadPoolTask(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            StringBuilder bigStr = new StringBuilder();
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bigStr.append("-BIG STR--BIG STR--BIG STR--BIG STR--BIG STR--BIG STR-");
                String a = new String("aaa");
                String b = new String("bbb");
                String c = new String("bbb");
            }
        }
    }
}
