package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习 求用户输入矩形的长和宽,求出矩形的面积和周长,并将结果显示在屏幕上.
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class RectangularCalculation {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩形从长");
        int length = scanner.nextInt();
        System.out.println("输入的长度为" + length);
        System.out.println("请输入矩形的宽");
        int width = scanner.nextInt();
        System.out.println("输入的宽为" + width);
        int perimeter = 2 * length + 2 * width;
        System.out.println("矩形的周长为" + perimeter);
        int area = length * width;
        System.out.println("矩形的面积为" + area);
    }
}
