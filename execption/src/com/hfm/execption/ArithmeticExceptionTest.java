package com.hfm.execption;

/**
 * @author hfm
 * @version 1.01 2020-04-07 22:09
 * @date 2020/4/7
 */
public class ArithmeticExceptionTest {
    int x;

    public static void main(String[] args) {
        int y;
        ArithmeticExceptionTest c = new ArithmeticExceptionTest();
        y = 3 / c.x;
        System.out.println("program ends ok!");
    }
}
