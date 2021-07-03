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

        // format 方法格式化
        System.out.println(localDateTime);
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter));

        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(isoDateTime.format(localDateTime));
        System.out.println(localDateTime.format(isoDateTime));

        System.out.println("================");
        // 方式二：本地化的格式 ofLocalizedDateTime ->  FormatStyle.SHORT 与 FormatStyle.MEDIUM
        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(shortFormat.format(localDateTime));
        DateTimeFormatter mediumFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(mediumFormat.format(localDateTime));

        // ofLocalizedDate -》 FormatStyle.SHORT\FormatStyle.MEDIUM\FormatStyle.FULL\FormatStyle.LONG
        DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(fullFormat.format(localDateTime));
        DateTimeFormatter longFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(longFormat.format(localDateTime));

        System.out.println("================");
        // 方式三：自定义格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(localDateTime);
        System.out.println(dateTimeFormatter2.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter2));

        // parse 方法解析
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2020-04-14 04:39:22");
        System.out.println(parse1);

        // 解析
        TemporalAccessor parse = dateTimeFormatter.parse("2020-04-14");
        System.out.println(parse);
    }
}
