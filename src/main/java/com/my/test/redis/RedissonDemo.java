package com.my.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunchengfei on 2017/12/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class RedissonDemo {
    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        RLock lock = redissonClient.getLock("anylock");
                        countDownLatch.await();
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "获取了锁");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "释放了锁");
                        lock.unlock();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("--------countDown模拟并发，争抢锁--------");
        countDownLatch.countDown();

        Thread.sleep(1000 * 60);
    }
}
