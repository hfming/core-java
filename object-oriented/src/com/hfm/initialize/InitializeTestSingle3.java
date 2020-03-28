package com.hfm.initialize;

/**
 * 构造代码块与显示初始化语句执行顺序
 * 创建一个对象
 *
 * @author hfm
 * @version 1.01 2020-03-24 16:38
 * @date 2020/3/24
 */
public class InitializeTestSingle3 {
    /**
     * E 显示初始化语句
     */
    private String init = "A 的显示初始化语句";

    /**
     * A 静态代码块
     */
    static {
        // 编译时异常，说明静态代码块执行时 init 变量还没有定义，所以静态代码块是优先与显示初始化语句之前执行的
        //System.out.println(init);
        System.out.println("A 的静态代码块");
    }

    /**
     * B 构造代码块
     */ {
        // 编译通过，说明构造代码块在运行时 init 变量已经定义
        System.out.println(init);
        System.out.println("A 的构造代码块");
    }

    /**
     * C 构造函数
     */
    public InitializeTestSingle3() {
        // 构造函数执行时，如果显示初始化语句优先与构造函数则输出其赋值，否则输出成员变量的初始化赋值
        System.out.println(init);
        System.out.println("A 的构造函数");
    }

    public static void main(String[] args) {
        InitializeTestSingle3 initializeTestA = new InitializeTestSingle3();
    }
}