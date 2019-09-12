package com.sun.dev.thread.threadpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Chengfei.Sun on 17/03/03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class MyDefineThreadPool {
    @Test
    public void testInvoke() throws ExecutionException, InterruptedException {
        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        tasks.add(new SleepShortTime());
        tasks.add(new SleepLongTime());

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(Callable<String> task : tasks){
            executorService.submit(task);
        }

//        for (Future<String> item : result) {
//            System.out.println(item.get());
//        }
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());

        executorService.shutdown();

        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
    }

    private class SleepShortTime implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("shortTime execute start");
            Thread.sleep(2000);
            System.out.println("shortTime execute end");
            return "result shortTime";
        }
    }

    private class SleepLongTime implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("longTime execute start");
            Thread.sleep(3000);
            System.out.println("longTime execute end");
            return "result longTime";
        }
    }
}
