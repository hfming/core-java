package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * java.text.DateFormat:是日期/时间格式化子类的抽象类
 *
 * @author hfm
 * @version 1.01 2020-03-30 22:17
 * @date 2020/3/30
 */
public class DateFormatAndSimpleDateFormatTest {
    private SimpleDateFormat simpleDateFormat;
    private Scanner sc = new Scanner(System.in);

    /**
     * 计算已经出生了多少天
     *
     * @throws ParseException
     */
    @Test
    private void birthNumDay() throws ParseException {
        // 1.使用Scanner类中的方法next, 获取出生日期
        System.out.println("请输入您的出生日期,格式:yyyy-MM-dd");
        String birthdayDateString = sc.next();

        // 2.使用DateFormat类中的方法parse, 把字符串的出生日期, 解析为Date格式的出生日期
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = simpleDateFormat.parse(birthdayDateString);

        // 3.把Date格式的出生日期转换为毫秒值
        long birthdayDateTime = birthdayDate.getTime();

        // 4.获取当前的日期, 转换为毫秒值
        long todayTime = System.currentTimeMillis();
        // 5.使用当前日期的毫秒值-出生日期的毫秒值
        long time = todayTime - birthdayDateTime;
        // 6.把毫秒差值转换为天(s/1000/60/60/24)
        System.out.println(time / 1000 / 60 / 60 / 24);
    }

    /**
     * format 方法：格式化方法，把日期格式化为文本
     * 使用步骤:
     * * 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
     * * 2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
     */
    @Test
    public void formatTest() {
        // 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
        simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();

        // 2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式, 把Date日期格式化为符合模式的字符串(文本)
        String format = simpleDateFormat.format(date);

        System.out.println(date);
        System.out.println(format);
    }

    /**
     * parse 方法：解析方法，把文本解析为日期
     * 使用步骤:
     * * 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
     * * 2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
     * 注意:
     * * public Date parse(String source) throws ParseException
     * * parse方法声明了一个异常叫ParseException，如果字符串和构造方法的模式不一样,那么程序就会抛出此异常，调用一个抛出了异常的方法,就必须的处理这个异常,要么throws继续抛出这个异常,要么try catch自己处理
     */
    @Test
    public void parseTest() throws ParseException {
        // 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
        simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        // 2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
        Date date = simpleDateFormat.parse("2088年08月08日 15时51分54秒");

        System.out.println(date);
    }

    /**
     * 日期类转化成 数据库时间类对象
     *
     * @throws ParseException
     */
    @Test
    public void toSqlDate() throws ParseException {
        String time = "2020-03-23";
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(time);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }
}
