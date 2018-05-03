package com.my.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Chengfei.Sun on 2015/10/23.
 */
public class DateUtil {

    public static final String DATE_FORMAT_TIME_T = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_TIME_R = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";

    public static String formatDate(Date nowDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar ca = Calendar.getInstance();
        ca.setTime(nowDate);
        return sdf.format(ca.getTime());
    }

    public static String formatStringToDate(String text, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(text);
    }

}
