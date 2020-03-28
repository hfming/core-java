package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:输入两个正整数m和n，求其最大公约数和最小公倍数
 *
 * @author hfm
 * @version 1.01 2020-03-19 11:36
 * @date 2020/3/19
 */
public class MultiplesAndDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入正整数a");
        int a = scanner.nextInt();
        System.out.println("正整数a 的值为" + a);
        System.out.println("请输入正整数b");
        int b = scanner.nextInt();
        System.out.println("正整数a 的值为" + b);

        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;
        int minyue = 0;
        for (int i = min - 1; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("最大公约数为" + i);
                minyue = i;
                break;
            }
        }
        for (int i = max; ; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println("最小公倍数为" + i);
                break;
            }
        }

        int num = max / minyue;
        for (int i = num; ; i++) {
            if (i * minyue % a == 0 && i % b == 0) {
                System.out.println("最小公倍数为" + i);
                break;
            }
        }
    }
}
