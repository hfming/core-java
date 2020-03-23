package com.hfm.baisc.java;

/**
 * 练习 编写程序求下列多项式的前50项的和：1-1/3+1/5-1/7+1/9-……
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetSum3 {
    public static void main(String[] args) {
        double result = 0;
        for (int i = 1; i <= 50; i++) {
            result += Math.pow(-1, i + 1) / (2 * i - 1);
            System.out.println(result);
        }
        System.out.println(result);
    }
}
