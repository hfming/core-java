package com.hfm.controlprocess;

/**
 * 顺序语句
 *
 * @author hfm
 * @version 1.01 2020-04-10 18:56
 * @date 2020/4/10
 */
public class Sequence {
    public static void main(String[] args) {
        // 赋值语句
        int a = 3;
        // 输出语句
        System.out.println(a);

        // 顺序语句，使用前面已经定义的变量
        int b = a + 1;
        System.out.println(b);
        // 空语句
        ;
        // 输出语句
        System.out.println("final");
    }
}
