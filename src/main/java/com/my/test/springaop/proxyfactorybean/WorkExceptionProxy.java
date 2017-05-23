package com.my.test.springaop.proxyfactorybean;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by sunchengfei on 2017/5/23.
 */
public class WorkExceptionProxy implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("after Throwing  Exception");
    }
}
