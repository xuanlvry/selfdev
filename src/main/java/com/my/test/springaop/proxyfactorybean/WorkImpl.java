package com.my.test.springaop.proxyfactorybean;

/**
 * Created by sunchengfei on 2017/5/22.
 */
public class WorkImpl implements IWork {
    public void work() {
        System.out.println("原workImpl执行work方法");
    }
}
