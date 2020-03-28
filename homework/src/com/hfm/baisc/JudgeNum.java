package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:实现判断一个4位整数，统计出此整数里面包含多少个偶数，多少个奇数的功能
 *
 * @author hfm
 * @version 1.01 2020-03-19 13:36
 * @date 2020/3/19
 */
public class JudgeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个4位正整数");
        int num = scanner.nextInt();
        int count = 0;
        int temp = num;
        while (temp > 0) {
            if ((temp % 10) % 2 == 0) {
                count++;
            }
            temp /= 10;
        }
        System.out.println("正整数" + num + "中有" + count + "个偶数 有" + (4 - count) + "个奇数");
    }
}
