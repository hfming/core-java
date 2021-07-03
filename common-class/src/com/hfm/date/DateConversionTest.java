package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author hfm
 * @version 1.01 2020-04-15 23:58
 * @date 2020/4/15
 */
public class DateConversionTest {
    /**
     * java.util.date 与 Calendar 相互转换
     */
    @Test
    public void DateToCalendar() {
        // 获取了当前的系统时间
        Calendar calendar = Calendar.getInstance();

        // Date 与 Calender 相互转换
        Date time = calendar.getTime();
        System.out.println(time);

        calendar.setTime(new Date());
    }

    /**
     *
     * java.util.Date 转化成 java.sql.Date对象
     * 将java.util.Date类转换为java.time.Localpate类的第二种方法java.sql.Date类提供了转换为LocalDate的方法，那么可以将java.util.Date先转换为java.sql.Date.
     * 通过java.sq1.Date的构造方法直接传入一个毫秒值可以构造一个java.sq1.Date对象，毫秒值可以通过java.uti1.Date对象的getTime方法获取到
     *
     * @throws ParseException
     */
    @Test
    public void toSqlDate() throws ParseException {
        Date date = new Date();

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        date.setTime(sqlDate.getTime());
        // 或者使用构造函数进行转换
        Date date1 = new Date(sqlDate.getTime());

        LocalDate localDate = sqlDate.toLocalDate();

    }

    /**
     * java.util.Date 类转化为 LoaclDate、localTime、LocalDateTime、ZonedDateTime类
     * 方式一：使用 Instant 类将 java.util.Date 转换为 java.time.LocalDate
     * java.time包中并没有提供很多的方式来进行直接转换，但是给之前的Date类，Calendar类在Java1.8都提供了一个新的方法，叫做toInstant，
     * 可以将当前对象转换为Instant对象，通过给Instant添加时区信息之后就可以转换为LocalDate对象。
     */
    @Test
    public void DateToLocalDate() {
        Date date = new Date();

        // 使用instat 作为中间对象转化为 LoaclDate 类
        Instant instant = date.toInstant();

        // 使用 atZone 添加时区,ZoneId.systemDefault()系统默认时区
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        // 使用 toLocalXXX 方法转化为其他日期对象
        LocalDate localDate = zonedDateTime.toLocalDate();
        LocalTime localTime = zonedDateTime.toLocalTime();
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        System.out.println(date);
        System.out.println(instant);
        System.out.println(zonedDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    /**
     * java.sql.Date 转化为 LoaclDate
     * java.sq1.Date类中的转换方法使用
     * java.sq1.Date类中提供直接转换为LocalDate的方法，toLocalDate
     * Timestamp类 转化为 LocalDateTime
     */
    @Test
    public void SqlDateAndSqlTimestamp() {
        // java.sql.Date 转化为 LoaclDate
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);

        // 使用 toLocalDate 方法直接转换成 LocalDate 对象
        LocalDate toLocalDate = date.toLocalDate();
        System.out.println(toLocalDate);

        // Timestamp类 转化为 LocalDateTime
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        // 使用 LocalDateTime 方法直接转化为 LocalDateTime 对象
        LocalDateTime toLocalDateTime = timestamp.toLocalDateTime();
        System.out.println(toLocalDateTime);
    }

    /**
     * calendar 类转化为  LoaclDate、localTime、LocalDateTime、ZonedDateTime 类
     * 将java.util.Calendar类转换为java.time.ZonedDateTime类Calendar对象自Java1.1开始提供了一个方法获取时区对象的方法，getTimeZone，
     * 要将Calendar对象转换为ZonedDateTime需要先获取到时区对象.从Java1.8开始TimeZone类提供了一个方法可以获取到zonedId.
     * 获取到zoneTd之后就可以初始化ZonedDateTime对象了，ZonedDateTime类有一个ofInstant方法，可以将一个Instant对象和ZonedId对象作为参数传入构造一个ZonedDateTime对象
     */
    @Test
    public void CalendarToZoneDateTime() {
        // 获取 Calendar 对象
        Calendar calendar = Calendar.getInstance();

        // 可以先将 calendar 转换成 instant 对象，在转换成 ZonedDateTime
//        Instant instant = calendar.toInstant();
//        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.systemDefault());

        // 或者直接使用 Calendar.getTimeZone() 方法获取 TimeZone 时区
        TimeZone timeZone = calendar.getTimeZone();

        ZoneId zoneId = timeZone.toZoneId();

        Instant instant = calendar.toInstant();

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.of(Calendar.YEAR, Calendar.MONTH + 1, Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE);
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.of(Calendar.YEAR, Calendar.MONTH + 1, Calendar.DAY_OF_MONTH);
        System.out.println(localDate);
    }

    /**
     *将java.util.calendar类转换为java.time.LocalDateTime类
     * Calendar对象可以获取到年月日时分秒的信息，这些信息可以作为LocalDateTime构造方法的参数
     */
    @Test
    public void calendarToLocalDateTime() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());

        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(localDateTime);
    }
}
