package com.sun.dev.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunchengfei on 2017/7/14.
 */
public class ReadWriteLockCacheTest implements Runnable {
    volatile static boolean cacheValid = true;

    private volatile static String data = "init data";

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void run() {
        String nameThread = Thread.currentThread().getName();

        lock.readLock().lock();
        if (!cacheValid) {
            lock.readLock().unlock();
            lock.writeLock().lock();

            data = nameThread;
//            if (!cacheValid) {
//                cacheValid = true;
//            }

            System.out.println(nameThread + "缓存失效，完成从db读取，并写入缓存data=" + data);
            lock.readLock().lock();
            lock.writeLock().unlock();

//            lock.writeLock().unlock();
//            lock.readLock().lock();
        }

        System.out.println(nameThread + "读取data：" + data);
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
        ReadWriteLockCacheTest runnable = new ReadWriteLockCacheTest();
        for (int i = 0; i < 200; i++) {
            new Thread(runnable, "t" + i).start();

            if (i == 5) {
                cacheValid = false;
                System.out.println("..........缓存失效..........");
            }
        }
    }
}
