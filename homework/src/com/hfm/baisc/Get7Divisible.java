package com.hfm.baisc;

/**
 * 练习 编写程序输出1-100之间所有能被7整除的偶数。
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class Get7Divisible {
    public static void main(String[] args) {
        for (int i = 0; i <= 99; i++) {
            if (i % 7 == 0) {
                System.out.println(i + "能够被7整除！");
            }
        }
    }
}
