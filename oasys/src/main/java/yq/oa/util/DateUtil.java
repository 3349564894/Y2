package yq.oa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String getFormatTime(Date date) {
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ;
        return dateFormat.format(date);
    }

    public static String now() {
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(d);
    }

    public static String string2Date(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formate2 = new SimpleDateFormat("EEE MMM dd zzz yyy", Locale.ENGLISH);
        String date = null;
        try {
            date = sdf.format(formate2.format(dateStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
