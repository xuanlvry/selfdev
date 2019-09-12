package com.sun.dev.thread;

/**
 * @author Chengfei.Sun on 2016/9/7.
 */
public class ThreadA extends Thread {
    int i = 0;

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            //1. isInterrupted()保证，只要中断标记为true就终止线程
            while (!isInterrupted()) {
                Thread.sleep(100);
                System.out.println(getName() + getId() + "执行了" + ++i + "次");
            }
        } catch (InterruptedException ie) {
            //2. InterruptedException异常保证，当InterruptedException异常产生时，线程被终止
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        t1.start();
        Thread.sleep(100); //睡眠100毫秒
        t1.interrupt();    //中断t1线程
    }
}
