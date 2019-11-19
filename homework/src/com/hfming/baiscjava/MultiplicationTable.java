package com.hfming.baiscjava;

/**
 * 练习 请编写程序输出九九乘法表
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
