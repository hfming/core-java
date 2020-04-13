package com.hfm.comment;
/*
    多行注释不能用在类注释上
 */

/**
 * 多行注释 Demo
 *
 * @author hfm
 * @version 1.2 2020-01-14
 */
public class MultilineComment {
    /*
        多行注释不能用于注释成员变量
     */
    /**
     * 文档注释用于对成员变量进行注释
     */
    private String str = "Hello World";

    public static void main(String[] args) {
        /*
         * 多行注释的使用范围在类之内,方法之内
         */
        System.out.println("Hello World !");
        /*
         * 类、类属性、类方法（静态方法）必须使用Javadoc的文档注释
         */
    }
    /*
        多行注释不能用在方法注释上
     */

    /**
     * 文档注释用于对方法进行注释
     *
     * @param s
     */
    public static void test(String s) {
        System.out.println("s");
    }
}
