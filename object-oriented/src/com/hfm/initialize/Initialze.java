package com.hfm.initialize;

/**
 * 构造函数、构造代码快、静态代码快的使用
 *
 * @author hfm
 * @version 1.10 2019-10-17
 */
public class Initialze {
    /**
     静态代码块
     *
     */
    static {
        // 结果为 null 说明静态代码块在运行时 staticField 静态变量已经定义但是还没有赋值，赋的是成员变量的默认初始值
        System.out.println(Initialze.staticField);
        System.out.println("静态构造代码块1");
    }
    /**
     * 静态变量
     */
    public static String staticField = "静态变量";
    /**
     * 显示初始化变量
     */
    public String field = "显示初始化变量";


    /**
     构造代码块
     *
     */ {
        System.out.println("构造代码块1");

    }

    /**
     静态代码块
     *
     */
    static {
        System.out.println(Initialze.staticField);
        System.out.println("静态构造代码块2");
    }

    /**
     *
     构造代码块
     */ {
        System.out.println("构造代码块2");
    }

    /**
     * 构造函数
     */
    public Initialze() {
        System.out.println("构造函数");
    }

    /**
     *
     构造代码块
     */ {
        System.out.println("构造代码块3");
    }

    /**
     *
     静态代码块
     */
    static {
        System.out.println("静态构造代码块3");
    }

    /**
     *
     构造代码块
     */ {
        System.out.println(field);
        System.out.println("构造代码块4");
    }
}
