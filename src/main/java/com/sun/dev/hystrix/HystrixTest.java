package com.sun.dev.hystrix;

import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunchengfei on 2018/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class HystrixTest {
    @Autowired
    private IHelloworldService helloworldService;

    @Test
    public void test() {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        try {
            for (int i = 0; i < 30; i++) {
                executor.execute(new Worker(helloworldService));
            }
        } catch (Exception e) {

        } finally {
            executor.shutdown();
        }

        System.out.println("main thread执行完毕");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Worker implements Runnable {
        private IHelloworldService helloworldService;

        public Worker(IHelloworldService helloworldService) {
            this.helloworldService = helloworldService;
        }

        @Override
        public void run() {
            helloworldService.updateUser(new UserInfo());
        }
    }

}
