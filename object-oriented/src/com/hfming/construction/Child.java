package com.hfming.construction;

/**
 * 构造函数、构造代码快、静态代码快的使用
 * @author hfm
 * @version 1.10 2019-10-17
 */
public class Child  extends  Father{
    /* 静态变量 */
    public static String s_StaticField = "子类静态变量";
    /* 变量 */
    public String s_Field = "子类显示初始化变量";

    // 静态构造代码块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类静态构造代码块");
    }

    // 构造代码块
    {
        System.out.println(s_Field);
        System.out.println("子类构造代码块");
    }
    public Child(){
        System.out.println("子类构造函数");
    }
}
