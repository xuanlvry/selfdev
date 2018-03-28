package com.my.test.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by sunchengfei on 2018/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class CallableTest {
    @Test
    public void test() {
        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //创建异步任务列表
        List<FutureTask<String>> futureTaskss = new ArrayList<FutureTask<String>>();

        List<Future<String>> futureTasks = new ArrayList<Future<String>>();
        try {
            for (int i = 0; i < 10; i++) {
                //创建异步任务
//                FutureTask<String> futureTask = new FutureTask<String>(new Worker());
//                futureTasks.add(futureTask);
                //执行
//                executor.submit(futureTask);

                Future<String> futureTask = executor.submit(new Worker());
                futureTasks.add(futureTask);
            }

            //获取值
            for (Future<String> item : futureTasks) {
                String result = item.get();
                System.out.println(result);
            }
        } catch (Exception e) {

        } finally {
            executor.shutdown();
        }
    }

    private class Worker implements Callable<String> {
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}
