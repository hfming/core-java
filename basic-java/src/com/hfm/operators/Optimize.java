package com.hfm.operators;

/**
 * 运算时的优化
 *
 * @author hfm
 * @version 1.01 2020-04-10 18:46
 * @date 2020/4/10
 */
public class Optimize {
    public static void main(String[] args) {
        // += 赋值运算符优化
        short s = 1;
        // s= s+1; // 错误
        // 正确
        s += 1;
        System.out.println(s);

        // 编译器的常量优化
        byte b1 = 1;
        byte b2 = 2;
        // 正确
        byte b3 = 1 + 2;
        System.out.println(b3);
        // byte b4=b1 + b2; // 错误
        // System.out.println(b4);
    }
}
