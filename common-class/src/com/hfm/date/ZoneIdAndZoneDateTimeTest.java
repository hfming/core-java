package com.hfm.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 时区类
 *
 * @author hfm
 * @version 1.01 2020-04-08 17:36
 * @date 2020/4/8
 */
public class ZoneIdAndZoneDateTimeTest {
    public static void main(String[] args) {
        // ZoneId:类中包含了所有的时区信息
        // ZoneId 的 getAvailableZoneIds():获取所有的ZoneId
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String s : zoneIds) {
            System.out.println(s);
        }

        // 默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        // ZoneId的of():获取指定时区的时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);
        localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);

        // ZonedDateTime:带时区的日期时间
        // ZonedDateTime的now():获取本时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // ZonedDateTime的now(ZoneId id):获取指定时区的ZonedDateTime对象
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime1);
    }
}
