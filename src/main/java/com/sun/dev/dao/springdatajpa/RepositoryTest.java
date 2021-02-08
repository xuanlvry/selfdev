package com.sun.dev.dao.springdatajpa;

import com.sun.dev.dao.entity.ShopCategoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunchengfei on 2018/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class RepositoryTest {
    @Autowired
    private ShopCategoryConfigRepository shopCategoryConfigRepository;

    @Test
    public void categoryTest() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(500, 500, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10000000), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 1000000000; i++) {
            executorService.execute(new Selector());
        }

        Thread.sleep(10000000000000000L);
    }

    private class Selector implements Runnable {
        @Override
        public void run() {
            long before = System.currentTimeMillis();
            List<ShopCategoryConfig> result = shopCategoryConfigRepository.findByDpShopId((int) (Math.random() * 100000000));
            long after = System.currentTimeMillis();
            System.out.println(after - before);
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            ShopCategoryConfig categoryConfig = new ShopCategoryConfig();
            categoryConfig.setDpShopId((int) (Math.random() * 100000000));
            categoryConfig.setMtShopId((int) (Math.random() * 100000000));
            categoryConfig.setConfigKey("config" + (int) (Math.random() * 100));
            categoryConfig.setBelong(1);
            shopCategoryConfigRepository.save(categoryConfig);
        }
    }
}