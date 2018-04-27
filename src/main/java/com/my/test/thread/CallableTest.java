package com.my.test.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by sunchengfei on 2018/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class CallableTest {
    @Test
    public void test() throws InterruptedException {
        int threadCount = 5;

        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        //任务列表
        List<Future<String>> futureTasks = new ArrayList<Future<String>>();
        try {
            for (int i = 0; i < threadCount; i++) {
                //创建异步任务
                Future<String> futureTask = executor.submit(new Worker());
                futureTasks.add(futureTask);
            }

            //获取值
            for (Future<String> item : futureTasks) {
                String result = item.get(10, TimeUnit.MILLISECONDS);
                System.out.println(result);
            }
        } catch (Exception e) {

        } finally {
            System.out.println("main thread shutdonwing " + new Date());
            executor.shutdownNow();
            System.out.println("main thread shutdonwed " + new Date());
        }

        Thread.sleep(10000);
    }

    private class Worker implements Callable<String> {
        @Override
        public String call() throws Exception {
            int count = 0;
            for(int i=0; i<10; i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " working");
                count++;
            }
            System.out.println(Thread.currentThread().getName() + " compleated");
            return Thread.currentThread().getName();
        }
    }
}
