package com.hfm.baisc.java;

/**
 * 练习:打印1-100之间13的倍数，使用for循环
 * 练习:用for循环计算1000以内偶数的和
 * 练习:使用双重循环打印20 * 8的矩形，使用for循环实现
 * 练习:输出从1到100之间所有不能被3整除的数;并输出这些整数的和
 *
 * @author hfm
 * @version 1.01 2020-03-19 11:00
 * @date 2020/3/19
 */
public class ForTest {
    public static void main(String[] args) {
        // get13Divisible();
        // printShape();
        // getSum();
        // print13Dis();
        get3Sum();
    }

    private static void get3Sum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0) {
                sum += i;
            } else {
                continue;
            }
        }
        System.out.println(sum);
    }

    private static void print13Dis() {
        for (int i = 1; i <= 100; i++) {
            if (i % 13 == 0) {
                continue;
            } else {
                System.out.println(i);
            }
        }
    }

    private static void getSum() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static void printShape() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void get13Divisible() {
        for (int i = 1; i <= 100; i++) {
            if (i % 13 == 0) {
                System.out.println(i);
            }
        }
    }
}
