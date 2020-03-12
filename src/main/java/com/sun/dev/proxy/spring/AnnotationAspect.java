package com.sun.dev.proxy.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sunchengfei on 2019-11-22.
 */
//@Component
@Aspect
public class AnnotationAspect {
    @Pointcut("args(com.sun.dev.service.UserInfo)")
    public void cut() {
    }

    @Before("cut()")
    public void beforeProcess() {
        System.out.println("@Aspect注解拦截，方法处理前");
    }
}