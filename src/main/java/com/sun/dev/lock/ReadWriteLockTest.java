package com.sun.dev.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Chengfei.Sun on 17/04/20.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock();
        Lock readLock = lock.readLock();

        System.out.println("aaa");
        writeLock.lock();

        readLock.lock();   //获取读锁
        readLock.unlock(); //释放读锁
        
        System.out.println("bbb");
        writeLock.unlock();

    }
}
