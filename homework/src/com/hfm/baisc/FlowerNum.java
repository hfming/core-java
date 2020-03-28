package com.hfm.baisc;

/**
 * 练习:输出所有的水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。例如： 153 = 1*1*1 + 3*3*3 + 5*5*5
 *
 * @author hfm
 * @version 1.01 2020-03-19 15:59
 * @date 2020/3/19
 */
public class FlowerNum {
    public static void main(String[] args) {
        for (int i = 100; i < 999; i++) {
            if (i == (Math.pow(i % 10, 3) + Math.pow(i / 10 % 10, 3) + Math.pow(i / 100, 3))) {
                System.out.println(i);
            }
        }
    }
}
