package com.hfm.initialize;

/**
 * 构造函数、构造代码块、静态代码块执行顺序
 * 创建一个对象
 *
 * @author hfm
 * @version 1.01 2020-03-24 16:38
 * @date 2020/3/24
 */
public class InitializeTestSingle1 {
    /**
     * B 构造代码块
     */ {
        System.out.println("A 的构造代码块");
    }

    /**
     * C 构造函数
     */
    public InitializeTestSingle1() {
        System.out.println("A 的构造函数");
    }

    /**
     * A 静态代码块
     */
    static {
        System.out.println("A 的静态代码块");
    }

    public static void main(String[] args) {
        InitializeTestSingle1 initializeTestA = new InitializeTestSingle1();
    }
}
