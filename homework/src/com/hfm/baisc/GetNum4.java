package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习 给定两个任意的正整数,求它们之间的所有完全平方数，完全平方数是指这个数是 某个整数的平方，例如 16，25，36等都是完全平方数。
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetNum4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个正整数");
        System.out.print("第一个正整数为：");
        int a = scanner.nextInt();
        System.out.print("第二个正整数数为：");
        int b = scanner.nextInt();
        //求最小值
        int max;
        int min;
        if (a <= b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        System.out.println(min);
        System.out.println(max);
        // 所有完全平方数
        for (int i = min; i <= max; i++) {
            if ((int) Math.pow((int) Math.sqrt(i), 2) == i) {
                System.out.println(i);
            }
        }
    }
}
