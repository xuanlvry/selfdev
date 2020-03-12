package com.sun.dev.proxy.spring;

/**
 * Created by sunchengfei on 2019/3/8.
 */
public class WorkImpl implements IWork {
    @Override
    public void work() {
        System.out.println("It's time to get to work");
    }

    @Override
    public void rest() {
        System.out.println("have a good rest");
    }
}

