package com.hfm.date;

import java.time.LocalDate;
import java.time.Period;

/**
 * 本地日期
 *
 * @author hfm
 * @version 1.01 2020-04-08 17:40
 * @date 2020/4/8
 */
public class LoclaDateTest1 {
    public static void main(String[] args) {
        //Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2028, 3, 18);
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        Period period1 = period.withYears(2);
        System.out.println(period1);
    }
}
