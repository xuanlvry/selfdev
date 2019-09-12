package com.sun.dev.exception;

/**
 * Created by sunchengfei on 2019-04-26.
 */
public class FinallyTest {
    public String someThing() {
        String s = "AAA";
        try {
            if (s.equals("AAA")) {
                System.out.println("will return");
                return "BBB";
            }

            System.out.println("11111");
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
        return s;
    }

    public static void main(String[] args) {
        FinallyTest test = new FinallyTest();
        System.out.println(test.someThing());
    }
}
