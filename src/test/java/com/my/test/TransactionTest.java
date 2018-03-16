package com.my.test;

import com.my.test.transaction.SelectForUpdateTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2017/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class TransactionTest {
    @Autowired
    private SelectForUpdateTest selectForUpdateTest;

    @Test
    public void test() {
        for (int i = 0; i < 5; i++) {
            ThreadClass threadClass = new ThreadClass(selectForUpdateTest);
            new Thread(threadClass).start();
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ThreadClass implements Runnable {
        private SelectForUpdateTest threadSelectForUpdateTest;

        public ThreadClass(SelectForUpdateTest selectForUpdateTest) {
            this.threadSelectForUpdateTest = selectForUpdateTest;
        }

        @Override
        public void run() {
            this.threadSelectForUpdateTest.useTransaction();
        }
    }
}
