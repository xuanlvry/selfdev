package com.my.test.proxy.spring;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by sunchengfei on 2019/3/8.
 */
@Service
public class WorkBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("运行前，proxy执行方法");
    }
}