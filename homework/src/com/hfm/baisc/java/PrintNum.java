package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习:随意给出一个整数，打印显示它的个位数，十位数，百位数的值。
 * 格式如下：数字xxx的情况如下:
 * 个位数：
 * 十位数：
 * 百位数：
 * 例如：数字153的情况如下：
 * 个位数：3
 * 十位数：5
 * 百位数：1
 *
 * @author hfm
 * @version 1.01 2020-03-18 21:41
 * @date 2020/3/18
 */
public class PrintNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int num = scanner.nextInt();
        int hNum = 0;
        int tNum = 0;
        int sNum = 0;
        if (num > 999) {
            hNum = num % 1000 / 100;
            tNum = num % 1000 % 100 / 10;
            sNum = num % 1000 % 10;
        } else {
            hNum = num / 100;
            tNum = num % 100 / 10;
            sNum = num % 10;
        }
        System.out.println("数字" + num + "的情况如下:");
        System.out.println("个位数:" + sNum);
        System.out.println("十位数:" + tNum);
        System.out.println("百位数:" + hNum);
    }
}
