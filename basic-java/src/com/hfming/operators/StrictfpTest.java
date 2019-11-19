package com.hfming.operators;

/**
 * strictfp 关键字 采用严格浮点型数据运算
 * @author hfm
 * @version 2019-10-17
 */
public class StrictfpTest {
    public strictfp static void main(String[] args) {
        double num1 = 1.0;
        double num2 = 3.0;

        System.out.println(num1 / num2);
    }
}
