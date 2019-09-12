package com.sun.dev.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunchengfei on 2019/4/17.
 */
public class ConditionTest implements Runnable {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            /**
             * 调用await()后，当前线程释放锁，并等待被唤醒。
             * 该线程被唤醒之前，必须先获得关联该condition的锁（即其他线程必须先释放锁）
             */
            condition.await();
            System.out.println("sub thread go on..");
            lock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动子线程
        ConditionTest conditionTest = new ConditionTest();
        new Thread(conditionTest).start();

        Thread.sleep(100);

        conditionTest.lock.lock();
        /**
         * 调用signal()，当前线程必须先获得关联该condition的锁
         */
        conditionTest.condition.signal();
        Thread.sleep(100);
        System.out.println("main thread do");

        conditionTest.lock.unlock();
    }
}





