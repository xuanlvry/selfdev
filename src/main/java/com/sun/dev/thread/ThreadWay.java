package com.sun.dev.thread;

/**
 * 继承Thread方式创建线程
 * Created by sunchengfei on 2019-07-18.
 */
public class ThreadWay extends Thread {
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
        new ThreadWay().start();
        new ThreadWay().start();
    }
}