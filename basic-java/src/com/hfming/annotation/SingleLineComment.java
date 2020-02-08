package com.hfming.annotation;

/**
 * 单行注释 Demo
 *
 * @author hfm
 * @version 1.2 2020-01-14
 */
public class SingleLineComment {
    public static void main(String[] args) {
        // 顾名思义单行注释的使用范围即为一行
        // 方法内部的单行注释应在注释语句上方另起一行使用 //进行注释
        // 单行注释（line comment）用//表示，编译器看到 “//” 会忽略该行 // 后的所文本。
        // 另外单行注释 "//" 符号与内容之间有一个空格
        // 一般方法内部的单行注释都是在写在代码的上方，方法外的在代码右方，多行注释一般写在代码的上方。
        System.out.println("hello world");

        /// 如果代码已经用 "//" 进行注释,则代码的注释应该用 "///" 进行注释
        // System.out.println("注释代码");
    }
}
