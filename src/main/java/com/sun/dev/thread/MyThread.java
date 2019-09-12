package com.sun.dev.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author Chengfei.Sun on 2016/9/6.
 */
public class MyThread extends Thread {
    Logger logger = LoggerFactory.getLogger(MyThread.class);

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "打印了日志");
        try {
            long millis = new Random().nextInt(1000);
            logger.info(Thread.currentThread().getName() + "执行逻辑" + millis + "ms");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Thread.currentThread().getName() + "再次打印了日志");
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        t1.start();

        Thread t2 = new MyThread("t2");
        t2.start();
    }
}
