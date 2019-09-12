package com.sun.dev.proxy.spring;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

/**
 * Created by sunchengfei on 2019/3/8.
 */
@Service
public class WorkThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(ClassNotFoundException ex) {
        System.out.println("对异常" + ex.getMessage() + "进行处理");
    }
}
