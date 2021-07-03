package com.hfm.operators;

/**
 * strictfp 关键字 采用严格浮点型数据运算
 *
 * @author hfm
 * @version 2019-10-17
 */
public strictfp class StrictfpTest {
    public static strictfp void main(String[] args) {
        func2();
        func2();
    }

    public static strictfp double func1() {
        double num1 = 1.0;
        double num2 = 3.0;

        System.out.println(num1 / num2);
        return num1 / num2;
    }

    public static double func2() {
        double num1 = 1.0;
        double num2 = 3.0;

        System.out.println(num1 / num2);
        return num1 / num2;
    }
}
