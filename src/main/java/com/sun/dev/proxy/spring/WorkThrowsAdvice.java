package com.sun.dev.proxy.spring;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by sunchengfei on 2019/3/8.
 */
public class WorkThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(ClassNotFoundException ex) {
        System.out.println("对异常" + ex.getMessage() + "进行处理");
    }
}
