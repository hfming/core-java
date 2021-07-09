package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 10:47
 * @Description
 * @date 2021/7/7
 */
public class StaticConst2 {
    /**
     * 静态代码块
     */
    static {
        System.out.println("ConstClass2 init!");
    }

    /**
     * 常量
     */
    public static final String HELLOWORLD = "hello world 2";

    public static void main(String[] args) {
        // "ConstClass init!"
        // "hello world"
        System.out.println(StaticConst2.HELLOWORLD);
    }
}

