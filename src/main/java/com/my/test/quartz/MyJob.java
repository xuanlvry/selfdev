package com.my.test.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * spring计划任务
 * @author Chengfei.Sun on 2015/7/23.
 */
@Component
@Lazy(false)
public class MyJob extends QuartzJobBean {
    private String str = null;

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("work1 " + Thread.currentThread().getName() + ": 计划任务执行：" + this.str);
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void doTask() throws InterruptedException {
//        System.out.println(new Date() + "work1 start");

//        Thread.sleep(2000);
        System.out.println(new Date() + " work1 " + Thread.currentThread().getName() +": 计划任务执行");
    }
}
