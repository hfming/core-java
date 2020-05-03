package com.hfm.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormat
 *
 * @author hfm
 * @version 1.01 2020-04-14 16:24
 * @date 2020/4/14
 */
public class DateTimeFormatTest {
    @Test
    public void dateTimeFormatTest() {
        // 方式一：预定义标准格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();

        // 格式化
        System.out.println(localDateTime);
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter));

        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(isoDateTime.format(localDateTime));
        System.out.println(localDateTime.format(isoDateTime));

        // 方式二：本地化的格式
        DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        // System.out.println(localDateTime.format(fullFormat));
        DateTimeFormatter longFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        // System.out.println(localDateTime.format(longFormat));
        DateTimeFormatter mediumFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        //  System.out.println(localDateTime.format(mediumFormat));
        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        // System.out.println(localDateTime.format(shortFormat));

        // 方式三：自定义格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(localDateTime);
        System.out.println(dateTimeFormatter2.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter2));

        // 解析
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2020-04-14 04:39:22");
        System.out.println(parse1);

        // 解析
        TemporalAccessor parse = dateTimeFormatter.parse("2020-04-14");
        System.out.println(parse);
    }
}
