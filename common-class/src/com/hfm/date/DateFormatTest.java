package com.hfm.date;

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
public class DateFormatTest {
    public static void main(String[] args) throws ParseException {
        //1.使用Scanner类中的方法next,获取出生日期
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的出生日期,格式:yyyy-MM-dd");
        String birthdayDateString = sc.next();
        //2.使用DateFormat类中的方法parse,把字符串的出生日期,解析为Date格式的出生日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = sdf.parse(birthdayDateString);
        //3.把Date格式的出生日期转换为毫秒值
        long birthdayDateTime = birthdayDate.getTime();
        //4.获取当前的日期,转换为毫秒值
        long todayTime = System.currentTimeMillis();
        //5.使用当前日期的毫秒值-出生日期的毫秒值
        long time = todayTime - birthdayDateTime;
        //6.把毫秒差值转换为天(s/1000/60/60/24)
        System.out.println(time / 1000 / 60 / 60 / 24);
    }

    /**
     * 使用DateFormat类中的方法parse,把文本解析为日期
     * 使用步骤:
     * 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
     * 2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
     * 注意:
     * public Date parse(String source) throws ParseException
     * parse方法声明了一个异常叫ParseException
     * 如果字符串和构造方法的模式不一样,那么程序就会抛出此异常
     * 调用一个抛出了异常的方法,就必须的处理这个异常,要么throws继续抛出这个异常,要么try catch自己处理
     */
    private static void demo02() throws ParseException {
        //1.创建SimpleDateFormat对象,构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2.调用SimpleDateFormat对象中的方法parse,把符合构造方法中模式的字符串,解析为Date日期
        //Date parse(String source)  把符合模式的字符串,解析为Date日期
        Date date = sdf.parse("2088年08月08日 15时51分54秒");
        System.out.println(date);
    }

    /**
     * 使用DateFormat类中的方法format,把日期格式化为文本
     * 使用步骤:
     * 1.创建SimpleDateFormat对象,构造方法中传递指定的模式
     * 2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
     */
    private static void demo01() {
        //1.创建SimpleDateFormat对象,构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2.调用SimpleDateFormat对象中的方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)
        //String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
        Date date = new Date();
        String d = sdf.format(date);
        //Sun Aug 08 15:51:54 CST 2088
        System.out.println(date);
        //2088年08月08日 15时51分54秒
        System.out.println(d);
    }
}
