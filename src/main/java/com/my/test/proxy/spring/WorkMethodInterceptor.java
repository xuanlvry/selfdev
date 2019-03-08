package com.my.test.proxy.spring;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

/**
 * Created by sunchengfei on 2019/3/8.
 */
@Service
public class WorkMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("方法前置处理");

        Object result = null;
        try {
            /** 通过methodInvocation.proceed()实现了对目标对象方法的调用 */
            result = invocation.proceed();
        } catch (Exception e) {
            System.out.println("对异常" + e.getMessage() + "进行处理");
        }

        System.out.println("方法后置处理");
        return result;
    }
}
