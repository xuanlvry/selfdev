package com.my.test.quartz;

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
        System.out.println(new Date() + " work2 " + Thread.currentThread().getName() +": 计划任务执行");
    }
}