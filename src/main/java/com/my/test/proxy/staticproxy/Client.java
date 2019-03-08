package com.my.test.proxy.staticproxy;

/**
 * Created by sunchengfei on 2018/5/25.
 */
public class Client {
    public static void main(String[] args) {
        ISubject subject = new RealSubject();
        ISubject proxy = new ProxySubject(subject);
        System.out.println(proxy.hello("world"));
    }
}
