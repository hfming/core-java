package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instast:相当与 Data 类
 * 可以获取毫秒数
 * 可以通过毫秒数获取时间对象
 *
 * @author hfm
 * @version 1.01 2020-04-08 17:49
 * @date 2020/4/8
 */
public class InstantTest {
    @Test
    public void instantTest() {
        Instant instant = Instant.now();
        // 记住要根据市区来显示时间
        System.out.println(instant);

        // 时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取使用 1970-01-01T00：00：00：00Z 纪元的毫秒的实例。
        // 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // 通过毫秒数获取instanst
        Instant instant1 = Instant.ofEpochMilli(1586852473254L);
        System.out.println(instant1);
    }
}
