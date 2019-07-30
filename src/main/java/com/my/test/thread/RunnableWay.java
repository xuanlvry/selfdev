package com.my.test.thread;

/**
 * 实现接口Runnable方式创建线程
 * Created by sunchengfei on 2019-07-18.
 */
public class RunnableWay implements Runnable {
    private int tickets = 5;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "出售票" + tickets--);
            }
        }
    }


    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        RunnableWay threadDemo = new RunnableWay();
        new Thread(threadDemo, "Sub1").start();
        new Thread(threadDemo, "Sub2").start();
    }
}