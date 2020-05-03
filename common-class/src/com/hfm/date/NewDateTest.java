package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author hfm
 * @version 1.01 2020-04-15 20:45
 * @date 2020/4/15
 */
public class NewDateTest {
    /**
     * 通过静态 now 方法获取日期对象
     */
    @Test
    public void nowTest() {
        Instant instant = Instant.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        // 2020-04-15T12:50:32.277066300Z
        // 格林尼治时间
        System.out.println(instant);
        // 2020-04-15
        // 日期
        System.out.println(localDate);
        // 20:50:32.297066800
        // 时间
        System.out.println(localTime);
        // 2020-04-15T20:50:32.297066800
        // 日期与时间
        System.out.println(localDateTime);
        // 2020-04-15T20:50:32.298066200+08:00[Asia/Shanghai]
        // 带时区的时间
        System.out.println(zonedDateTime);

        // 年，年月，月日 类的获取
        Year year = Year.now();
        YearMonth month = YearMonth.now();
        Month five = Month.of(12);
        MonthDay day = MonthDay.now();
        // 2020
        System.out.println(year);
        // 2020-04
        System.out.println(month);
        // DECEMBER
        System.out.println(five);
        // --04-15
        System.out.println(day);
    }

    /**
     * of 方法：根据给定的参数生成对应的日期/时间对象，以函数重载的方式多个出现，可以根据不同的参数生成对应的数据
     */
    @Test
    public void ofTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 04, 15, 21, 31);
        // 2020-04-15T21:31
        System.out.println(localDateTime);

        LocalDate localDate = LocalDate.of(2020, 04, 15);
        // 2020-04-15
        System.out.println(localDate);

        LocalTime localTime = LocalTime.of(21, 19, 31);
        // 21:19:31
        System.out.println(localTime);

        localDateTime = LocalDateTime.of(localDate, localTime);
        // 2020-04-15T21:19:31
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("Asia/Shanghai"));
        // 2020-04-15T21:19:31+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime);
    }

    /**
     * with 方法：设置方法，返回一个新的 localDateTime 不可变性
     */
    @Test
    public void withTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2022);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }

    /**
     * plus 方法：加法，返回一个新的 localDateTime 不可变性
     */
    @Test
    public void plusTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 4 天前
        LocalDateTime minusDays = localDateTime.plusDays(4);

        // 返回一个新的 localDateTime 不可变性
        System.out.println(minusDays == localDateTime);
        System.out.println(localDateTime);
        System.out.println(minusDays);

        // 2 小时前
        LocalDateTime minusHours = localDateTime.plusHours(2);
        System.out.println(minusHours);

        // 10 分钟前
        LocalDateTime minusMinutes = localDateTime.plusMinutes(10);
        System.out.println(minusMinutes);

        // 10 个月前
        LocalDateTime minusMonths = localDateTime.plusMonths(10);
        System.out.println(minusMonths);

        // 3 年前
        LocalDateTime minusYears = localDateTime.plusYears(3);
        System.out.println(minusYears);

        // 7 周前
        LocalDateTime minusWeeks = localDateTime.plusWeeks(7);
        System.out.println(minusWeeks);

        LocalDateTime plus = localDateTime.plus(Period.of(2, 3, 5));
        System.out.println(plus);

        LocalDateTime plus1 = localDateTime.plus(1, ChronoUnit.DECADES);
        System.out.println(plus1);

        LocalDateTime plus2 = localDateTime.plus(1, ChronoUnit.HALF_DAYS);
        System.out.println(plus2);
    }

    /**
     * minus 方法：减法，返回一个新的 localDateTime 不可变性
     */
    @Test
    public void minusTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 4 天前
        LocalDateTime minusDays = localDateTime.minusDays(4);

        // 返回一个新的 localDateTime 不可变性
        System.out.println(minusDays == localDateTime);
        System.out.println(localDateTime);
        System.out.println(minusDays);

        // 2 小时前
        LocalDateTime minusHours = localDateTime.minusHours(2);
        System.out.println(minusHours);

        // 10 分钟前
        LocalDateTime minusMinutes = localDateTime.minusMinutes(10);
        System.out.println(minusMinutes);

        // 10 个月前
        LocalDateTime minusMonths = localDateTime.minusMonths(10);
        System.out.println(minusMonths);

        // 3 年前
        LocalDateTime minusYears = localDateTime.minusYears(3);
        System.out.println(minusYears);

        // 7 周前
        LocalDateTime minusWeeks = localDateTime.minusWeeks(7);
        System.out.println(minusWeeks);
    }
}
