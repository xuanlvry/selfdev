package com.my.test.zookeeper.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunchengfei on 2017/11/22.
 */
public class CuretorLock {
    private CuratorFramework client;
    private InterProcessMutex lock;

    private String clientName;
    private String CURATOR_LOCK = "/curatorLock";

    public CuretorLock(String clientName) {
        this.clientName = clientName;

        client = CuratorFrameworkFactory.newClient("172.16.89.129:2181", 500000, 15000,
                new ExponentialBackoffRetry(1000, 3));
        client.start();
        System.out.println("客户端:" + clientName + "启动");

        //实例化zk分布式锁
        lock = new InterProcessMutex(this.client, CURATOR_LOCK);
    }

    public void lock() {
        System.out.println("客户端:" + clientName + "尝试获取锁");
        try {
//            boolean isLock = lock.acquire(1, TimeUnit.SECONDS);
//            if (isLock) {
//                System.out.println("客户端:" + clientName + "获得锁");
//            } else {
//                System.out.println("客户端:" + clientName + "未获得锁");
//            }

            lock.acquire();
            System.out.println("客户端:" + clientName + "获得锁");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            System.out.println("客户端:" + clientName + "处理完业务逻辑，释放锁");
            this.lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        CuretorLock curetorLock = new CuretorLock(Thread.currentThread().getName());
                        countDownLatch.await();
                        curetorLock.lock();
                        Thread.sleep(1000);
                        curetorLock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("--------countDown模拟并发，争抢锁--------");
        countDownLatch.countDown();
    }
}
