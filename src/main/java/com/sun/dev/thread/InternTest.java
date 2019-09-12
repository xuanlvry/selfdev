package com.sun.dev.thread;

/**
 * Created by sunchengfei on 2018/2/9.
 */
public class InternTest implements Runnable {
    private String userId;

    public InternTest(String userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        synchronized (userId.intern()) {
            System.out.println(Thread.currentThread().getName() + "[" + userId + "]开始运行了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "[" + userId + "]结束运行了");
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            String userId = "用户1";
            new Thread(new InternTest(userId)).start();

            String userId2 = "用户2";
            new Thread(new InternTest(userId2)).start();
        }


        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
