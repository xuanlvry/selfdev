package com.my.test.proxy.staticproxy;

/**
 * Created by sunchengfei on 2018/5/25.
 */
public class ProxySubject implements ISubject {
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public String hello(String str) {
        if (str.startsWith("add")) {
            return null;
        }
        return subject.hello(str);
    }
}
