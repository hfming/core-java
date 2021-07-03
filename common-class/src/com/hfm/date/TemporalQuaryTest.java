package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

/**
 * @author hfm
 * @version 1.01 2020-04-16 0:06
 * @date 2020/4/16
 */
public class TemporalQuaryTest {
    @Test
    public void temporalQuaryTes() {
        Long query = LocalDateTime.now().query((TemporalAccessor temporalAccessor) -> {
            LocalDate localDate = LocalDate.from(temporalAccessor);
            System.out.println("当前时间是："+localDate);

            // 创建当年 5月1号 日期对象
            LocalDate dateTime = LocalDate.of(localDate.getYear(), Month.MAY, 1);
            // 判断是否在 5月1号后面
            if (localDate.isAfter(dateTime)) {
                dateTime = dateTime.plusYears(1);
            }
            System.out.println("下一个5月1号："+dateTime);
            // 计算时间差
            return ChronoUnit.DAYS.between(localDate, dateTime);
        });
        System.out.println(query);
    }
}
