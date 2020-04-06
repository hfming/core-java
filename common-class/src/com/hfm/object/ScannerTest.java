package com.hfm.object;

import java.util.Scanner;

/**
 * 键盘输入类的使用
 *
 * @author hfm
 * @version 1.10 2019-10-16
 */
public class ScannerTest {
    public static void main(String[] args) {
        // 创建Scanner类对象
        Scanner scanner = new Scanner(System.in);
        // 只有Java.lang 包中的类不需要导包
        System.out.println("输入");

        int num1 = scanner.nextInt();
        System.out.println(num1);

        String str = scanner.next();
        System.out.println(str);

        String str2 = scanner.nextLine();
        System.out.println(str2);
    }
}
