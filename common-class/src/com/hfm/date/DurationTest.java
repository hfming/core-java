package com.hfm.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Duration:持续时间，用于计算两个“时间”间隔，表示秒或者纳秒，用于处理较短的时间，需要提高精确性。
 *
 * @author hfm
 * @version 1.01 2020-04-08 17:38
 * @date 2020/4/8
 */
public class DurationTest {
    public static void main(String[] args) {
        // Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15, 23, 32);
        // between():静态方法，返回Duration对象，表示两个时间的间隔
        Duration duration = Duration.between(localTime1, localTime);

        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());

        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 11, 14, 22, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 7, 12, 15, 23, 33);
        Duration duration1 = Duration.between(localDateTime, localDateTime1);
        System.out.println(duration1.toHours());
        System.out.println(duration1.toDays());
    }
}
