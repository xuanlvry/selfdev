package com.my.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by sunchengfei on 2018/6/5.
 */
public class MyMainTest {
    public static void main(String[] args) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dayFormat.parse("1999-12-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
