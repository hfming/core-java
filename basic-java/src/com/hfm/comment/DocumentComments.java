package com.hfm.comment;

/**
 * 文档注释 Demo
 * 文档注释也是多行注释,文档注释一般用与注释类、方法、成员变量，一般不会用在方法内部
 * 文档注释内容可以被 JDK 提供的工具 javadoc 所解析，生成一套以网页文件形式体现的该程序的说明文档
 * 文档注释可以用于对类进行注释
 *
 * @author hfm
 * @version 1.2 2020-01-14
 */
public class DocumentComments {
    /**
     * 文档注释可以对成员变量进行注释
     */
    private static String str = "Hello World!";

    /**
     * 文档注释可以对 main 方法进行注释
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 文档注释一般不会在方法内部使用
         */
        helloWorld("hello world ！");
    }

    /**
     * 文档注释可以对方法进行注释
     *
     * @param str
     */
    private static void helloWorld(String str) {
        System.out.println(str);
    }
}
