package com.my.test.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Chengfei.Sun on 17/05/08.
 */
public class Client {
    public static void main(String[] args){
        Subject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),
                handler);

        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
    }
}
