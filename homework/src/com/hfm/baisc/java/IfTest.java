package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习:要求用户输入两个数a和b，如果a能被b整除或者a加b大于1000，则输出a；否则输出b。
 * 练习: 使用条件结构实现，如果用户名等于字符‘青’，密码等于数字‘123’，就输出“欢迎你，青”，否则就输出“对不起，你不是青”。
 * 提示：先声明两个变量，一个是char型的，用来存放用户名，一个是int型的，用来存放密码。
 *
 * @author hfm
 * @version 1.01 2020-03-19 10:35
 * @date 2020/3/19
 */
public class IfTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getAOrB(scanner);
        load(scanner);
    }

    private static void load(Scanner scanner) {
        System.out.println("请输入用户名");
        String name = scanner.next();
        System.out.println("请输入数字密码");
        int password = scanner.nextInt();
        if (("青").equals(name) && password == 123) {
            System.out.println("welcome 青!");
        } else {
            System.out.println("用户名或密码错误!");
        }
    }

    private static void getAOrB(Scanner scanner) {
        System.out.println("请输入正整数a");
        int a = scanner.nextInt();
        System.out.println("正整数a的值为" + a);
        System.out.println("请输入正整数b");
        int b = scanner.nextInt();
        System.out.println("正整数a的值为" + b);
        if (a % b == 0 || (a + b) > 1000) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
