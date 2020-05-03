package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
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
     * Date 类转化为 LoaclDate、localTime、LocalDateTime、ZonedDateTime类
     */
    @Test
    public void DateToLocalDate() {
        Date date = new Date();

        // 使用instat 作为中间对象转化为 LoaclDate 类
        Instant instant = date.toInstant();

        // 使用 atZone 添加时区
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        // 使用 to 方法转化为其他日期对象
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
     * sql.Date 转化为 LoaclDate
     * Timestamp类 转化为 LocalDateTime
     */
    @Test
    public void SqlDateAndSqlTimestamp() {
        // sql.Date 转化为 LoaclDate
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);

        LocalDate toLocalDate = date.toLocalDate();
        System.out.println(toLocalDate);

        // Timestamp类 转化为 LocalDateTime
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        LocalDateTime toLocalDateTime = timestamp.toLocalDateTime();
        System.out.println(toLocalDateTime);
    }

    /**
     * calendar 类转化为  LoaclDate、localTime、LocalDateTime、ZonedDateTime 类
     */
    @Test
    public void CalendarToZoneDateTime(){
        Calendar calendar = Calendar.getInstance();

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
}
