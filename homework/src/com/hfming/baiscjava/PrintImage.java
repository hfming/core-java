package com.hfming.baiscjava;

/**
 * 练习 在屏幕上输出一个n行的金字塔图案，例如，若n=4,则图案如下
 * *
 * ***
 * *****
 * *******
 */
public class PrintImage {
    public static void main(String[] args) {
        String str1 = " ";
        String str2 = "*";
        for (int i1 = 0; i1 < 10; i1++) {
            for (int j1 = 0; j1 < 10 - i1; j1++) {
                System.out.print(str1);
            }
            for (int k1 = 0; k1 < i1 * 2 - 1; k1++) {
                System.out.print(str2);
            }
            System.out.println();
        }
    }
}
