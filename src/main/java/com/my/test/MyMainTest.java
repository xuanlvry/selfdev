package com.my.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int month = c.get(Calendar.MONTH);
        System.out.println("month = " + month);
    }
}
