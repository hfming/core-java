package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习请写1个程序,这个程序要求用户从控制台输入两个数, 然后输出两个数的和.
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class GetSum {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字1");
        int num1 = scanner.nextInt();
        System.out.println("请输入数字1");
        int num2 = scanner.nextInt();
        int sum = num1 + num2;
        System.out.println("数字1与数字2的和为" + sum);
    }
}
