package com.hfm.baisc.java;

/**
 * 练习: 编写程序，打印100-200之间的质数
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Outer:
        for (int i1 = 2; i1 <= 100; i1++) {
            Inner:
            for (int j1 = 2; j1 <= Math.sqrt(i1); j1++) {
                if (i1 % j1 == 0) {
                    continue Outer;
                }
            }
            System.out.println(i1);
        }
    }
}
