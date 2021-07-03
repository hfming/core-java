package com.hfm.variable;

/**
 * 变量声明/变量的定义
 *
 * @author hfm
 * @version 1.01 2020-04-09 22:27
 * @date 2020/4/9
 */
public class VariableDeclarations {
    public static void main(String[] args) {
        // 编译错误：使用 myNumber 之前并未定义过 myNumber，变量需要先定义再使用
        // System.out.println(myNumber);

        // 变量的声明
        int myNumber;

        /// 变量需要先声明，再初始化才能使用
        // 编译错误：使用 myNumber 之前并未赋值过 myNumber，变量未赋值不能使用
        // System.out.println(myNumber);

        // 编译错误: 不可以在同一个作用域内定义同名的变量，相同作用域内不能有同名变量
        // int myNumber

        // 变量赋值
        myNumber = 20;

        // 变量的使用
        System.out.println(myNumber);
    }
}
