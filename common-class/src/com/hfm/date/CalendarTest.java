package com.hfm.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class CalendarTest {
    public static void main(String[] args) throws ParseException {
        // 获取当前系统时间的对象。
        Date date = new Date();
        //在使用println方法时，会自动调用Date类中的toString方法。Date类对Object类中的toString方法进行了覆盖重写，所以结果为指定格式的字符串。
        System.out.println("年份：" + date);

        // 获取了当前的系统时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.getInstance().getClass());

        /// 获取方法

        System.out.println("年份：" + calendar.get(Calendar.YEAR));
        System.out.println("月份：" + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("日：" + calendar.get(Calendar.DATE));
        System.out.println("时：" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分：" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));

        // add(int field, int amount)
        calendar.add(Calendar.YEAR, 1);
        System.out.println(calendar.get(Calendar.YEAR));

        // set(int field, int value)
        calendar.set(Calendar.YEAR, 2022);
        System.out.println(calendar.get(Calendar.YEAR));

        calendar.set(2022, 04, 23);
        System.out.println(calendar.get(Calendar.YEAR)+" "+calendar.get(Calendar.MONTH)+" "+calendar.get(Calendar.DATE));

        // 该月第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // 该周第几天
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        // 该年第几天
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // 设置方法
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.DAY_OF_WEEK, 3);

        // 添加方法
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // Date 与 Calender 相互转换
        Date time = calendar.getTime();
        System.out.println(time);

        calendar.setTime(new Date());
    }
}
