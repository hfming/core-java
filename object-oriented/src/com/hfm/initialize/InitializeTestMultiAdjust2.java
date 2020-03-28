package com.hfm.initialize;

/**
 * 静态代码块与静态初始化语句的执行顺序
 * 创建多个对象
 * 调整顺序
 *
 * @author hfm
 * @version 1.01 2020-03-24 16:38
 * @date 2020/3/24
 */
public class InitializeTestMultiAdjust2 {
    /**
     * D 静态赋值语句
     */
    public static String staticInit = "A 的静态赋值语句";

    /**
     * A 静态构造代码块
     */
    static {
        // 编译通过，说明 staticInit 变量已经定义
        System.out.println(InitializeTestMultiAdjust2.staticInit);

        System.out.println("A 的静态构造代码块");
    }

    /**
     * B 构造代码块
     */ {
        System.out.println(InitializeTestMultiAdjust2.staticInit);
        System.out.println("A 的构造代码块");
    }

    /**
     * 构造函数
     */
    public InitializeTestMultiAdjust2() {
        System.out.println(InitializeTestMultiAdjust2.staticInit);
        System.out.println("A 的构造函数");
    }

    public static void main(String[] args) {
        InitializeTestMultiAdjust2 initializeTestA = new InitializeTestMultiAdjust2();
        InitializeTestMultiAdjust2 initializeTestB = new InitializeTestMultiAdjust2();
    }
}
