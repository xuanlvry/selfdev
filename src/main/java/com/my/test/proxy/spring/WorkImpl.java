package com.my.test.proxy.spring;

/**
 * Created by sunchengfei on 2019/3/8.
 */
public class WorkImpl implements IWork {
    @Override
    public void work() {
        System.out.println("原workImpl执行work方法");
        System.out.println(1 / 0);
    }
}

