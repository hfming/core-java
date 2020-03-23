package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习: 使用三元运算符获取两个数中的较大数，获取三个数中的较大数
 * @author hfm
 * @version 1.01 2020-03-18 22:39
 * @date 2020/3/18
 */
public class GetMax2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数");
        int num2 = scanner.nextInt();
        System.out.println((num1>num2)? num1:num2);

        System.out.println("请输入第三个数");
        int num3 = scanner.nextInt();
        System.out.println((num3>((num1>num2)? num1:num2))? num3:((num1>num2)? num1:num2));
    }
}
