package com.my.test.guava;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sunchengfei on 2019/3/3.
 */
@Slf4j
public class ExceptionTest {
    public String handle() {
        try {
            return null;
        } catch (Exception e) {

        } finally {
            return null;
        }
    }

    public void exceptionTest() {
        try {
            System.out.println("正常逻辑");
            System.out.println(1 / 0);  //代码发生异常
            log.info("程序继续执行01");  //代码不会执行该处
        } catch (Exception e) {
            log.error("测试发生异常:{}", e.getMessage());
        }
        log.info("程序继续执行02");      //代码继续执行
    }

    class DefaultException extends Exception {
        public DefaultException() {
            super();
        }

        @Override
        public String toString() { //重写toString()方法，自定义语句
            return "我的自定义异常语句";
        }

        public DefaultException(String msg) {
            //调用Exception类的构造方法，存入异常信息
            super(msg);
        }
    }

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\journaldev.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("AAAA");
            e.printStackTrace();
        }
        /**resources are closed as soon as try-catch block is executed.*/
    }
}
