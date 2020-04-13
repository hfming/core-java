package com.hfm.variable;

/**
 * 变量初始化 Demo
 *
 * @author hfm
 * @version 1.1 2020-01-14
 */
public class VariableInit {
    public static void main(String[] args) {
        ///变量的初始化方式有两种

        // 静态初始化，在定义变量时就进行初始化赋值
        int way1 = 15;
        System.out.println(way1);

        // 同时创建三个int变量，并且同时各自赋值
        int x = 100, y = 200, z = 300;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        // 动态初始胡，在定义变量的时候不进行初始化赋值
        int way2;
        way2 = 16;
        System.out.println(way2);
    }
}
