package com.my.test.thread;

/**
 * @author Chengfei.Sun
 */
public class Sync {
    public void test() {
        synchronized(Sync.class){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}
