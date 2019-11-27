package com.hxyc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 日期工具类
 * @Author admin
 * @Date 2019/11/19 17:39
 **/
public class DateUtil {
    /*
       * 获取当前天的起始时间
       */
    public static Date getStartTime(Calendar day) {
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }
    /*
     * 获取当前天的结束时间
     */
    public static Date getEndTime(Calendar day) {
        day.set(Calendar.HOUR_OF_DAY, 23);
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse("2019-11-19"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
        String weekhand = sdf.format(cal.getTime());
        System.out.println("当前时间所在周周一日期："+weekhand);

        cal.set(Calendar.DATE, cal.get(cal.DATE) + 6);
        String weeklast = sdf.format(cal.getTime());
        System.out.println("当前时间所在周周日日期："+weeklast);

        cal.set(Calendar.DATE, cal.get(cal.DATE) + 1);
        weeklast = sdf.format(cal.getTime());
        System.out.println("当前时间所在周第二周周一日期："+weeklast);

        cal.set(Calendar.DATE, cal.get(cal.DATE) + 6);
        weeklast = sdf.format(cal.getTime());
        System.out.println("当前时间所在周第二周周日日期："+weeklast);
    }
}
