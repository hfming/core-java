package com.hfm.object;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author hfm
 * @version 1.01 2020-04-02 19:29
 * @date 2020/4/2
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        // 对应的日期格式如：2018‐01‐16 15:06:38
        DateFormat format = new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");

        Date date = new Date();
        // 创建日期格式化对象,在获取格式化对象时可以指定风格
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = df.format(date);
        // 2008年1月23日
        System.out.println(str);

        str = "2018年12月11日";
        date = df.parse(str);
        // Tue Dec 11 00:00:00 CST 2018
        System.out.println(date);

        System.out.println("请输入出生日期 格式 YYYY‐MM‐dd");
        // 获取出生日期,键盘输入
        String birthdayString = new Scanner(System.in).next();
        // 将字符串日期,转成Date对象
        // 创建SimpleDateFormat对象,写日期模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy‐MM‐dd");
        // 调用方法parse,字符串转成日期对象
        Date birthdayDate = sdf.parse(birthdayString);
        // 获取今天的日期对象
        Date todayDate = new Date();
        // 将两个日期转成毫秒值,Date类的方法getTime
        long birthdaySecond = birthdayDate.getTime();
        long todaySecond = todayDate.getTime();
        long secone = todaySecond - birthdaySecond;
        if (secone < 0) {
            System.out.println("还没出生呢");
        } else {
            System.out.println(secone / 1000 / 60 / 60 / 24);
        }
    }
}
