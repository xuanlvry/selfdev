package com.my.test.thread.threadpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by sunchengfei on 2018/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class ExecutorServiceDemo {
    @Test
    public void test() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        CompletionService<String> completionExecutor = new ExecutorCompletionService<String>(executor);

        Future<String> resultFuture = null;
        for (int i = 0; i < 1; i++) {
            resultFuture = executor.submit(new Worker());
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resultFuture.cancel(true);
        System.out.println(resultFuture.isCancelled());

//        try {
//            String result = resultFuture.get(1000, TimeUnit.MILLISECONDS);
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Worker implements Callable<String> {
        @Override
        public String call() throws Exception {
            Date start = new Date();
            System.out.println("---------------------------------------- " + start + Thread.currentThread().getName() + "：start ----------------------------------------");

            while ((new Date()).getTime() - start.getTime() <= 3000) {

            }

            System.out.println("---------------------------------------- " + new Date() + Thread.currentThread().getName() + ": end ----------------------------------------");
            return Thread.currentThread().getName();
        }
    }
}
