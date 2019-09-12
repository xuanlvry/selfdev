package com.sun.dev.thread.threadpool;

import com.sun.dev.service.GoodsInfo;
import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Chengfei.Sun on 17/03/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class TestThreadPool {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        /**
         * 线程池
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
//        tasks.add(new UserTask());

        /**
         * 原生多线程
         */
        FutureTask<Object> task1 = new FutureTask<Object>(new UserTask());
        new Thread(task1).start();

        FutureTask<Object> task2 = new FutureTask<Object>(new GoodsTask());
        new Thread(task2).start();

        System.out.println(task1.get());
        System.out.println(task2.get());
    }

    //任务类
    private class UserTask implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("tom");
            userInfo.setSex(1);
            return userInfo;
        }
    }

    private class GoodsTask implements Callable<Object> {
        @Override
        public Object call() throws Exception {
            GoodsInfo goodsInfo = new GoodsInfo();
            goodsInfo.setGoodsName("iphonex");
            return goodsInfo;
        }
    }
}
