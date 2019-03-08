package com.my.test.proxy.java;

import com.my.test.proxy.staticproxy.ISubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Chengfei.Sun on 17/05/08.
 */
public class DynamicProxy implements InvocationHandler {
    private ISubject subject;

    public DynamicProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(subject, args);
        System.out.println(System.currentTimeMillis());

        return result;
    }
}
