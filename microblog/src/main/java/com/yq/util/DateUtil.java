package com.yq.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getFormatTime(Date date) {
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int currYear = c.get(Calendar.YEAR);
        c.setTime(date);
        DateFormat dateFormat;
        if (currYear == c.get(Calendar.YEAR)) {
            dateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
        } else {
            dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        }
        return dateFormat.format(date);
    }

    public static String now() {
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(d);
    }

    public static Date string2Date(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date setDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date);
        return cal.getTime();
    }

}
