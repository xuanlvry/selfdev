package com.my.test.springaop.proxyfactorybean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by sunchengfei on 2017/5/22.
 */
public class WorkBeforeProxy implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("运行前，proxy执行方法");
    }
}
