package com.my.test.springaop.proxyfactorybean;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Created by sunchengfei on 2017/5/22.
 */
public class WorkProxy implements IntroductionInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if (implementsInterface(methodInvocation.getMethod().getDeclaringClass())) {
            return methodInvocation.getMethod().invoke(this, methodInvocation.getArguments());
        } else {
            return methodInvocation.proceed();
        }
    }

    public boolean implementsInterface(Class<?> aClass) {
        return aClass.isAssignableFrom(IWork.class);
    }
}
