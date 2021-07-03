package com.hfm.date;

import java.util.Date;

/**
 * java.util.Date:表示日期和时间的类
 *
 * @author hfm
 * @version 1.01 2020-03-30 22:15
 * @date 2020/3/30
 */
public class DateTest {
    public static void main(String[] args) {
        // 获取当前系统时间到1970 年 1 月 1 日 00:00:00经历了多少毫秒
        // System类提供的public static long currentTimeMillis()用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        // 此方法适于计算时间差。
        System.out.println(System.currentTimeMillis());

        // Date类的带参数构造方 Date(long date) :传递毫秒值,把毫秒值转换为Date日期
        Date date = new Date(0L);
        // Thu Jan 01 08:00:00 CST 1970
        System.out.println(date);

        date = new Date(3742767540068L);
        // Sun Aug 08 09:39:00 CST 2088
        System.out.println(date);

        // Date类的空参数构造方法
        // Date() 获取当前系统的日期和时间
        Date date2 = new Date();
        //Sun Aug 08 12:23:03 CST 2088
        System.out.println(date2);

        // long getTime() 把日期转换为毫秒值(相当于System.currentTimeMillis()方法)返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long time = date.getTime();
        //3742777636267
        System.out.println(time);

        // Sun Aug 08 09:39:00 CST 2088
        System.out.println(date.toString());

        // 创建 java.sql.Date 对象
        java.sql.Date sqlDate = new java.sql.Date(3742767540068L);
        // XXXX-XX-XX 年-月-日
        System.out.println(sqlDate);
        System.out.println(sqlDate.toString());
        // 毫秒数
        System.out.println(sqlDate.getTime());

        // java.util.Date 与  java.sql.Date 相互转化
        // 通过强制数据类型转化

        sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        date = new Date(sqlDate.getTime());
        System.out.println(date);
    }
}
