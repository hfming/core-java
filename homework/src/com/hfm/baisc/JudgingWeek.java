package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习 使用程序判断假设今天是星期4，那么问10天后的今天是星期几？
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class JudgingWeek {
    public static void main(String[] args) {
        // 创建键盘输入函数
        Scanner scanner = new Scanner(System.in);
        int today = 4;
        System.out.println("星期" + (((today + 10) % 7) + 1));
    }
}
