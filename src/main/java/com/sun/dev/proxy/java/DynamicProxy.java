package com.sun.dev.proxy.java;

import com.sun.dev.proxy.staticproxy.ISubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Chengfei.Sun on 17/05/08.
 */
public class DynamicProxy implements InvocationHandler {
    //我们要代理的真实对象
    private ISubject subject;

    //构造方法，给我们要代理的真实对象赋值
    public DynamicProxy(ISubject subject) {
        this.subject = subject;
    }

//    public <T> T getProxy(){
//        return (T) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                this);
//    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前，我们可以添加一些自己的操作
        System.out.println(System.currentTimeMillis());

        Object result = method.invoke(subject, args);

        //在代理真实对象后，也可以添加自己的操作
        System.out.println(System.currentTimeMillis());

        return result;
    }
}
