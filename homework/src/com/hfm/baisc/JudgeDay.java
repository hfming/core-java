package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:从键盘分别输入年、月、日，判断这一天是当年的第几天
 * 注：判断一年是否是闰年的标准：1）可以被4整除，但不可被100整除或2）可以被400整除
 *
 * @author hfm
 * @version 1.01 2020-03-19 15:28
 * @date 2020/3/19
 */
public class JudgeDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年/月/日并用/号隔开");
        String time = scanner.next();
        String[] times = time.split("/");
        int year = Integer.parseInt(times[0]);
        int month = Integer.parseInt(times[1]);
        int day = Integer.parseInt(times[2]);
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            getDay(month, day, 29);
        } else {
            getDay(month, day, 28);
        }
    }

    private static void getDay(int month, int day, int i) {
        if (month == 1) {
            System.out.println("这一天是当年的第" + day + "天");
        }
        if (month == 2) {
            System.out.println("这一天是当年的第" + (day + 31) + "天");
        }
        if (month == 3) {
            System.out.println("这一天是当年的第" + (day + 31 + i) + "天");
        }
        if (month == 4) {
            System.out.println("这一天是当年的第" + (day + 31 * 2 + i) + "天");
        }
        if (month == 5) {
            System.out.println("这一天是当年的第" + (day + 31 * 2 + i + 30) + "天");
        }
        if (month == 6) {
            System.out.println("这一天是当年的第" + (day + 31 * 3 + i + 30) + "天");
        }
        if (month == 7) {
            System.out.println("这一天是当年的第" + (day + 31 * 3 + i + 30 * 2) + "天");
        }
        if (month == 8) {
            System.out.println("这一天是当年的第" + (day + 31 * 4 + i + 30 * 2) + "天");
        }
        if (month == 9) {
            System.out.println("这一天是当年的第" + (day + 31 * 5 + i + 30 * 2) + "天");
        }
        if (month == 10) {
            System.out.println("这一天是当年的第" + (day + 31 * 5 + i + 30 * 3) + "天");
        }
        if (month == 11) {
            System.out.println("这一天是当年的第" + (day + 31 * 5 + i + 30 * 4) + "天");
        }
        if (month == 12) {
            System.out.println("这一天是当年的第" + (day + 31 * 5 + i + 30 * 5) + "天");
        }
    }
}
