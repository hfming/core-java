package com.hfming.baiscjava;

import java.util.Scanner;

/**
 * 练习 给定一个整数，把它的各位数字倒排过来形成一个新的整数例如：给定12345   输出54321  ；给定 9870  输出789
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetNum5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int input = scanner.nextInt();
        int m = 0;
        while (input > 0) {
            m *= 10;
            m += input % 10;
            input /= 10;
        }
        System.out.println(m);
    }
}
