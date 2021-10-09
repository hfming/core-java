package com.hfm.nochange;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-17 18:10
 * @Description
 * @date 2021/9/17
 */
public class FinalTest {
    final static int A = 1;
    static int b = 2;

    final int C = 3;
    static int D = 4;

    public static void main(String[] args) {
        System.out.println(A);
        System.out.println(FinalTest.b);
        System.out.println(new FinalTest().C);
        System.out.println(FinalTest.D);
    }
}
