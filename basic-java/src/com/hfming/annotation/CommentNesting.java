package com.hfming.annotation;

/**
 * 文档注释与多行注释的区别: 文档注释的内容可以用于生成一个开发者文档。
 *
 * @author hfm
 * @version 1.1 2019-09-17
 */
public class CommentNesting {
    /**
     * 文档注释:文档注释也是多行注释。 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 多行注释：多行注释一般写在代码的上方，
         */
        // 单行注释：一般方法内部的单行注释都是在写在代码的上方，方法外的在代码右方，多行注释一般写在代码的上方。
        System.out.println("Hello World !");
        // 注释的嵌套
        /*
         * // 多行注释可以嵌套单行注释
         */
        /**
         * // 文档注释可以嵌套单行注释
         */
        // // 单行注释可以嵌套单行注释
        // 多行注释不能嵌套多行注释，多行注释不能与文档注释相互嵌套
    }
}

