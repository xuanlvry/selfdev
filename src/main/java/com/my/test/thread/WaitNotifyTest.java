package com.my.test.thread;

/**
 * @author Chengfei.Sun on 2016/9/7.
 */
public class WaitNotifyTest implements Runnable {
    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            try {
                System.out.println(Thread.currentThread().getName() + " wait");
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " do something");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyTest myThread = new WaitNotifyTest();
        new Thread(myThread, "A1").start();
        new Thread(myThread, "A2").start();
        new Thread(myThread, "A3").start();
        Thread.sleep(1000);
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " nofify");
            obj.notifyAll();
        }
    }
}
