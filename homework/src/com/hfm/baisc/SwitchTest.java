package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习: 使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输出 “other”。
 * 提示：String word = scan.next(); char c = word.charAt(0); switch(c){}
 *
 * @author hfm
 * @version 1.01 2020-03-19 15:15
 * @date 2020/3/19
 */
public class SwitchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个字符");
        String aChar = scanner.next();

        switch (aChar) {
            case "a":
            case "b":
            case "c":
            case "d":
            case "e":
                System.out.println(aChar.charAt(0));
                break;
            default:
                System.out.println("other");
        }

    }
}
