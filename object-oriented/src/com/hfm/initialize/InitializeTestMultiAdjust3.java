package com.hfm.initialize;

/**
 * 构造代码块与显示初始化语句执行顺序
 * 创建多对象
 * 调整位置
 *
 * @author hfm
 * @version 1.01 2020-03-24 16:38
 * @date 2020/3/24
 */
public class InitializeTestMultiAdjust3 {
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
        // 编译不通过，说明构造代码块在运行时 init 变量还没有定义，构造代码块优先与显示初始化语句
        //System.out.println(init);
        System.out.println("A 的构造代码块");
    }

    /**
     * E 显示初始化语句
     */
    private String init = "A 的显示初始化语句";

    /**
     * C 构造函数
     */
    public InitializeTestMultiAdjust3() {
        // 构造函数执行时，如果显示初始化语句优先与构造函数则输出其赋值，否则输出成员变量的初始化赋值
        System.out.println(init);
        System.out.println("A 的构造函数");
    }

    public static void main(String[] args) {
        InitializeTestMultiAdjust3 initializeTestA = new InitializeTestMultiAdjust3();
        InitializeTestMultiAdjust3 initializeTestB = new InitializeTestMultiAdjust3();
    }
}
