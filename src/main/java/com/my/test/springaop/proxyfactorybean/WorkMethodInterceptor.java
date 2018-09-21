package com.my.test.springaop.proxyfactorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by sunchengfei on 2017/5/23.
 */
public class WorkMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("interceptor method name:" + methodInvocation.getMethod().getName());
        //通过methodInvocation.proceed()实现了对目标对象方法的调用
        Object result = methodInvocation.proceed();
        System.out.println("result:" + result);
        return result;
    }
}
