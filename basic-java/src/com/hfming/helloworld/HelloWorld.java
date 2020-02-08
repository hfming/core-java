package com.hfming.helloworld;

/**
 * 第一个Java程序 Demo
 * Hello World
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class HelloWorld {
    // psvm + 回车 自动导入main 语句
    public static void main(String[] args) {
        test();
        // sout 自动导入 System.out.println();
        System.out.println();
    }

    public static void test() {
        // 单行注释在被注释者的上方
        // 第一种方法
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();

        // 第二种方法
        // 读取字符串数组的方式
        String[] greeting2 = new String[2];
        greeting2[0] = "Welcom to core Java";
        greeting2[1] = "by hfm";
        for (String g : greeting2) {
            System.out.println(g);
        }
        for (int i = 0; i < greeting2.length; i++) {
            System.out.print("=");
        }
        System.out.println();

        // 方法三
        /// java 10 var 类型推断并不适用于类或实例的变量，或方法的参数。
        var greeting3 = new String[2];
        greeting3[0] = "Welcom to core Java";
        greeting3[1] = "by hfm";
        for (var g : greeting3) {
            System.out.println(g);
        }
        for (var i = 0; i < greeting3.length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
