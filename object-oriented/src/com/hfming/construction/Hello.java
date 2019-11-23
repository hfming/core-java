package com.hfming.construction;

/**
 * 构造函数、构造代码快、静态代码快的使用
 *
 * @author hfm
 * @version 1.10 2019-10-17
 */
public class Hello {
    /* 静态变量 */
    public static String staticField = "静态变量";
    /* 显示初始化变量 */
    public String field = "显示初始化变量";


    //构造代码块
    {
        System.out.println("构造代码块1");

    }

    //静态代码块
    static {
        System.out.println(staticField);
        System.out.println("静态构造代码块1");
    }

    //构造代码块
    {
        System.out.println("构造代码块2");
    }

    /**
     * 构造函数
     */
    public Hello() {
        System.out.println("构造函数");
    }

    //构造代码块
    {
        System.out.println("构造代码块3");
    }

    //静态代码块
    static {
        System.out.println("静态构造代码块2");
    }

    //构造代码块
    {
        System.out.println(field);
        System.out.println("构造代码块4");
    }
}
