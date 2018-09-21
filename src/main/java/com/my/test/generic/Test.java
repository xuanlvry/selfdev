package com.my.test.generic;

/**
 * Created by sunchengfei on 2018/8/29.
 */
public class Test<T> {
    public void testMethod(T t) {
        System.out.println(t.getClass().getName());
    }

    public <T> T testMethod1(T t) {
        return t;
    }

    public String testMethod2(T t) {
        return null;
    }

    public static void main(String[] args) {
        Test<Integer> test = new Test<>();
    }
}
