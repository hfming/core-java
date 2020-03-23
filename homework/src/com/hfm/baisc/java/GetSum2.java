package com.hfm.baisc.java;

/**
 * 练习 编写程序求 1+3+5+7+……+99 的和值。
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetSum2 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 99; i++) {
            sum += i;
        }
        System.out.println("1到99的和为" + sum);
    }
}
