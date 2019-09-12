package com.sun.dev.quartz;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Chengfei.Sun on 2016/10/27.
 */
@Component
@Lazy(false)
public class MyJob2 {
    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask() {
        Date start = new Date();
        System.out.println(start + " ---work2--- " + Thread.currentThread().getName() +"start");

        while ((new Date()).getTime() - start.getTime() <= 3000) {

        }

        System.out.println(new Date() + " ---work2--- " + Thread.currentThread().getName() +": 计划任务执行");
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask3() {
        System.out.println(new Date() + " work3 " + Thread.currentThread().getName() +": 计划任务执行");
    }
}

