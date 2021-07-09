package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 11:56
 * @Description 多个静态变量与静态代码块的执行顺序
 * @date 2021/7/7
 */
public class MulStaticTest {
    static int height;
    static int age = 10;

    static {
        age = 20;
    }

    static {
        name = "Jack";
    }

    static String name = "Rose";

    public static void main(String[] args) {
        // 0
        // 20
        // Rose
        System.out.println(height);
        System.out.println(age);
        System.out.println(name);
    }
}
