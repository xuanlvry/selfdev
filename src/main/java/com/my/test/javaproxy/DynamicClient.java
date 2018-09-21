package com.my.test.javaproxy;

import com.my.test.javaproxy.staticproxy.ISubject;
import com.my.test.javaproxy.staticproxy.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by sunchengfei on 2018/5/25.
 */
public class DynamicClient {
    public static void main(String args[]) {
        //要代理的真实对象
        ISubject realSubject = new RealSubject();

        //创建中介类实例
        InvocationHandler handler = new DynamicProxy(realSubject);

        //获取类加载器
        ClassLoader cl = realSubject.getClass().getClassLoader();

        //动态产生一个代理类
        ISubject proxy = (ISubject) Proxy.newProxyInstance(cl, realSubject.getClass().getInterfaces(), handler);

        //通过代理类，执行doSomething方法；
        System.out.println(proxy.hello("world"));

        System.out.println(proxy.getClass().getName());
    }
}
