package com.hfming.helloworld;

/**
 * 第一个Java程序 Demo
 * Hello World
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class HelloWorld { // 类名与文件名必须要相同,并且大小写也要相同(Java 区分大小写)
    // psvm + 回车 自动导入main 语句
    public static void main(String[] args) {  // main 方法的写法是固定的,它代表程序的起点,一个 Java 程序有且仅有一个 main 方法
        test();
        // sout 自动导入 System.out.println();
        // 代表打印输出语句（其实就是屏幕显示）
        // 希望显示什么东西，就在小括号当中填写什么内容
        System.out.println();
    }

    public static void test() {
        // 单行注释在被注释者的上方
        // 第一种方法
        String greeting = "Welcome to Core Java!";
        System.out.println(greeting);
        // for 循环
        for (int i = 0; i < greeting.length(); i++) {
            System.out.print("=");
        }
        System.out.println();

        // 第二种方法
        // 读取字符串数组的方式
        String[] greeting2 = new String[2];
        greeting2[0] = "Welcom to core Java";
        greeting2[1] = "by hfm";
        // for-each 循环
        for (String g : greeting2) {
            System.out.println(g);
        }
        // for 循环
        for (int i = 0; i < greeting2.length; i++) {
            System.out.print("=");
        }
        System.out.println();

        // 方法三
        /// java 10 var 类型推断并不适用于类或实例的变量，或方法的参数。
        var greeting3 = new String[2];
        greeting3[0] = "Welcom to core Java";
        greeting3[1] = "by hfm";
        // for-each 循环
        for (var g : greeting3) {
            System.out.println(g);
        }
        // for 循环
        for (var i = 0; i < greeting3.length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
