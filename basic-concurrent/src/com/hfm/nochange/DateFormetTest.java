package com.hfm.nochange;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-17 17:18
 * @Description
 * @date 2021/9/17
 */
public class DateFormetTest {
    @Test
    public void simpleDateFormet() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(sdf.parse("1951-04-21"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @Test
    public void simpleDateFormetSych() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (sdf) {
                    try {
                        System.out.println(sdf.parse("1951-04-21"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Test
    public void dateTimeFormet() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDate date = dtf.parse("2018-10-01", LocalDate::from);
                System.out.println(date);
            }).start();
        }
    }
}
