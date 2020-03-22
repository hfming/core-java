package com.hfm.helloworld;

/**
 * 第一个Java程序 Demo
 * Hello World
 * <p>
 * java程序编写-编译-运行的过程
 * 1.编写：我们将编写的 java 代码保存在以".java"结尾的源文件中
 * 2.编译：使用 javac.exe 命令编译我们的java源文件。格式：javac 源文件名.java
 * 3.运行：使用 java.exe 命令解释运行我们的字节码文件。 格式：java 类名
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
// 在一个java源文件中可以声明多个class。但是，只能最多有一个类声明为public的。而且要求声明为public的类的类名必须与源文件名相同。
public class HelloWorld { // 类名与文件名必须要相同,并且大小写也要相同(Java 区分大小写)
    // psvm + 回车 自动导入main 语句
    public static void main(String[] args) {  // main 方法的写法是固定的,它代表程序的起点,一个 Java 程序有且仅有一个 main 方法 arguments:参数
        test();
        // sout 自动导入 System.out.println();
        // 代表打印输出语句（其实就是屏幕显示）
        // 希望显示什么东西，就在小括号当中填写什么内容
        System.out.println();

        // 不换行输出
        System.out.print("");
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
