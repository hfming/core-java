package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 10:47
 * @Description
 * @date 2021/7/7
 */
public class StaticConst1 {
    /**
     * 静态常量
     */
    public static final String HELLOWORLD = "hello world 1";

    /**
     * 静态代码块
     */
    static {
        System.out.println("ConstClass1 init!");
    }

    public static void main(String[] args) {
        // "ConstClass1 init!"
        // "hello world"
        System.out.println(StaticConst1.HELLOWORLD);
    }
}

