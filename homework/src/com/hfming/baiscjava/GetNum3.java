package com.hfming.baiscjava;

/**
 * 练习 求所有满足如下条件的四位数：千位上的数字大于百位数字，百位数字大于十位数字，十位数字大于个位数字，并且千位数字是其他三位数字的和。
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetNum3 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 9999; i++) {
            // 千位
            int a1 = i / 1000;
            // 百位
            int b1 = (i / 100) % 10;
            // 十位
            int c1 = (i / 10) % 100 % 10;
            //  个位
            int d1 = i % 10;
            if (a1 > b1 && b1 > c1 && c1 > d1 && (a1 == b1 + c1 + d1)) {
                System.out.print(i + "    ");
            } else {
                continue;
            }
        }
    }
}
