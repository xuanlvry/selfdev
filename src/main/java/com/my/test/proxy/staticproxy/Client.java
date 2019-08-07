package com.my.test.proxy.staticproxy;

/**
 * Created by sunchengfei on 2018/5/25.
 */
public class Client {
    public static void main(String[] args) {
        //定义一个真实角色
        ISubject subject = new RealSubject();
        //定义代理角色
        ISubject proxy = new ProxySubject(subject);
        //调用
        System.out.println(proxy.hello("world"));
    }
}
