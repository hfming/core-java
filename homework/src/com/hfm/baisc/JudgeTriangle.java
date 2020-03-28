package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:有3个整数，给出提示信息：
 * 能否创建三角形；
 * 两边之和大于第三边 三个条件都要写
 * 如果能构建三角形，提示是直角三角形还是等边三角形等腰三角形还是普通三角形；最后输出三角形面积；
 *
 * @author hfm
 * @version 1.01 2020-03-19 14:03
 * @date 2020/3/19
 */
public class JudgeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入三个数并用, 号隔开");
        String arr = scanner.next();
        String[] arrs = arr.split(",");
        int a = Integer.parseInt(arrs[0]);
        int b = Integer.parseInt(arrs[1]);
        int c = Integer.parseInt(arrs[2]);
        if (a + b > c || a + c > b || b + c > a) {
            System.out.println(arr + "三个数可以创建三角形");
        } else {
            System.out.println(arr + "三个数不可以创建三角形");
        }
        if ((a + b > c || a + c > b || b + c > a) && (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2))) {
            System.out.println("可以创建直角三角形");
        }
        if ((a + b > c || a + c > b || b + c > a) && a == b && b == c) {
            System.out.println("可以创建等腰三角形");
        }
        System.out.println("三角形的面积为" + Math.sqrt((a + b + c) * (a + b - c) * (a + c - b) * (b + c - a)) / 4);
    }
}
