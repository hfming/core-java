package com.hfm.date;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

/**
 * LoaclDateTime
 *
 * @author hfm
 * @version 1.01 2020-04-13 23:02
 * @date 2020/4/13
 */
public class LocalDateTimeTest {
    @Test
    public void testLoaclDateTime() {
        // 通过 now 静态方法获取 localDateTime 对象
        LocalDateTime localDateTime = LocalDateTime.now();

        // 2020-04-13T23:04:43.008604300
        System.out.println(localDateTime);

        // of():设置指定的年、月、日、时、分、秒。没有偏移量
        localDateTime = LocalDateTime.of(2020, 04, 23, 21, 29);

        System.out.println(localDateTime);

        // 当月的第几天
        System.out.println(localDateTime.getDayOfMonth());
        // 当周的第几天
        System.out.println(localDateTime.getDayOfWeek());
        // 当年的第几天
        System.out.println(localDateTime.getDayOfYear());

        // 返回一个新的 localDateTime 不可变性
        // 设置方法
        localDateTime = localDateTime.withDayOfMonth(2);

        // 添加方法
        localDateTime = localDateTime.plusDays(3);

        // 减法
        localDateTime = localDateTime.minusDays(4);
    }
}
