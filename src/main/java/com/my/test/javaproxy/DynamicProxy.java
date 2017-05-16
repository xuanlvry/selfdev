package com.my.test.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Chengfei.Sun on 17/05/08.
 */
public class DynamicProxy implements InvocationHandler {
    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前添加一些操作");

//        System.out.println("Method：" + method);
//        method.invoke(subject, args);

        System.out.println("代理完成后添加一些操作");
        return null;
    }
}
