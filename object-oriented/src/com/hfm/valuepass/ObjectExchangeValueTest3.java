package com.hfm.valuepass;

/**
 * 值传递练习
 *
 * @author hfm
 * @version 1.01 2020-04-03 12:23
 * @date 2020/4/3
 */
public class ObjectExchangeValueTest3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // 需要在method 方法被调用后，仅打印 a=100,b=200,请写出 method 方法
        method(a, b);
        // method 方法直接结束程序，不让后面的代码执行
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    // 传入基本数据类型，交换失败，因此可以直接输出，然后结束程序不让其返回
    private static void method(int a, int b) {
        System.out.println("a=100");
        System.out.println("b=200");
        System.exit(1);
    }
}

