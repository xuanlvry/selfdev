package com.my.test.springaop.proxyfactorybean;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Created by sunchengfei on 2017/5/23.
 */
public class WorkIntroductionInterceptorProxy implements IntroductionInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }

    public boolean implementsInterface(Class<?> aClass) {
        return false;
    }
}
