package com.hfm.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster:时间校正器 是一个接口，传入with方法的是其实现类对象
 * TemporalAdjusters:调用其静态方法可以返回TemporalAdjuster 的实现类对象
 *
 * @author hfm
 * @version 1.01 2020-04-08 17:41
 * @date 2020/4/8
 */
public class TemporalAdjusterTest {
    public static void main(String[] args) {
        // 获取当前日期的下一个周日是哪天？
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);

        // 当月第一天
        TemporalAdjuster firstDayOfMonth = TemporalAdjusters.firstDayOfMonth();
        localDateTime = LocalDateTime.now().with(firstDayOfMonth);
        System.out.println(localDateTime);

        // 下个月第一天
        TemporalAdjuster firstDayOfNextMonth = TemporalAdjusters.firstDayOfNextMonth();
        localDateTime = LocalDateTime.now().with(firstDayOfNextMonth);
        System.out.println(localDateTime);

        // 获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with((temporal) -> {
            LocalDate date = (LocalDate) temporal;
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                return date.plusDays(3);
            } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                return date.plusDays(2);
            } else {
                return date.plusDays(1);
            }
        });
        System.out.println("下一个工作日是：" + localDate);

        // 使用枚举类对象 DayOfWeek:封装类星期
        TemporalAdjuster nextDayOfWeek = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDateTime with = localDateTime.with(nextDayOfWeek);
        System.out.println(with);
    }
}
