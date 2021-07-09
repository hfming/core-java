package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 10:47
 * @Description
 * @date 2021/7/7
 */
public class StaticVariable2 {
    /**
     * 静态代码块
     */
    static {
        HELLOWORLD = "静态代码块";
    }

    /**
     * 静态变量
     */
    public static String HELLOWORLD = "hello world 4";

    public static void main(String[] args) {
        // "hello world"
        System.out.println(StaticVariable2.HELLOWORLD);
        // 静态代码块与静态变量的初始化顺序与位置有关，谁在前面谁先执行
    }
}

