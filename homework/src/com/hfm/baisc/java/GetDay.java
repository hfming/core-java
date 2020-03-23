package com.hfm.baisc.java;

/**
 * 练习:3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数。
 *
 * @author hfm
 * @version 1.01 2020-03-19 11:18
 * @date 2020/3/19
 */
public class GetDay {
    public static void main(String[] args) {
        int n = 3000;
        for (int i = 0; ; i++) {
            n /= 2;
            if (n < 5) {
                System.out.println(i);
                break;
            }
        }
    }
}
