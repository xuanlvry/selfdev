package com.my.test.javaproxy;

/**
 * Created by Chengfei.Sun on 17/05/08.
 */
public class RealSubject implements Subject {
    public void rent() {
        System.out.println("into rent method");
    }

    public void hello(String str) {
        System.out.println("hello:" + str);
    }
}
