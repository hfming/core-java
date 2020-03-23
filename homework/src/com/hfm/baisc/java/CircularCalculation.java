package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习 要求用户输入圆形的半径,求出圆形的面积和周长,并将结果显示在屏幕上.
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class CircularCalculation {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入圆的半径");
        int radius = scanner.nextInt();
        System.out.println("输入的半径为" + radius);
        double pi = 3.14;
        double perimeter = 2 * radius * pi;
        System.out.println("圆的周长为" + perimeter);
        double area = pi * Math.pow(radius, 2);
        System.out.println("圆的面积为" + area);
    }
}
