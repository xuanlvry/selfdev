package com.my.test.thread;

/**
 * @author Chengfei.Sun
 */
public class SynchronizedTest implements Runnable {
    public void test() {
        synchronized(SynchronizedTest.class){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }

    @Override
    public void run() {

    }

    public static void main(String[] args){

    }
}
