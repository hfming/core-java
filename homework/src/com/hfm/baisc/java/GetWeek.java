package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习: 今天是周二，100天以后是周几？
 *
 * @author hfm
 * @version 1.01 2020-03-18 20:54
 * @date 2020/3/18
 */
public class GetWeek {
    public static void main(String[] args) {
        System.out.println("请输入今天星期几(数字1-7)");
        Scanner scanner = new Scanner(System.in);
        int weekBegin = 0;
        while (true) {
            weekBegin = scanner.nextInt();
            if (1 <= weekBegin && weekBegin <= 7) {
                break;
            } else {
                System.out.println("请重新输入今天星期几(数字1-7)");
            }
        }
        System.out.println("请输入经过的天数");
        int day = scanner.nextInt();
        int weekEnd = (day + weekBegin) % 7;
        if (weekEnd == 0) {
            weekEnd = 7;
        }
        System.out.println("今天是星期" + weekBegin + "经过" + day + "天后是星期" + weekEnd);
    }
}
