package com.hfm.junitdemo;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-25 21:51
 * @Description 要测试的类
 * @date 2021/6/25
 */
public class MyFunction {
    @MyCheckAnnotation()
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    @MyCheckAnnotation()
    public int subtraction(int a, int b) {
        return a - b;
    }

    @MyCheckAnnotation()
    public int multiplication(int a, int b) {
        return a * b;
    }

    @MyCheckAnnotation()
    public int division(int a, int b) {
        return a / b;
    }

    @MyCheckAnnotation()
    public int modulo(int a, int b) {
        return a % b;
    }
}
