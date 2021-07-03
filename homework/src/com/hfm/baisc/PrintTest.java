package com.hfm.baisc;

/**
 * 输出练习
 *
 * @author hfm
 * @version 1.01 2020-03-18 19:05
 * @date 2020/3/18
 */
public class PrintTest {
    public static void main(String[] args) {
        xiDaDa();
        helloWorld();
    }

    /**
     * 练习: 创建如下的类，使得运行的话可以输出
     * 姓名: 习大大
     * 性别: 男
     * 地址: 中南海
     */
    private static void xiDaDa() {
        System.out.println("姓名: 习大大");
        System.out.println("性别: 男");
        System.out.println("地址: 中南海");
    }

    /**
     * 独立编写hello world程序，编译并运行
     */
    private static void helloWorld() {
        System.out.println("Hello World!");
    }
}
