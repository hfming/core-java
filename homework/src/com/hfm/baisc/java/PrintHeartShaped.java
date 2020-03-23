package com.hfm.baisc.java;

/**
 * 练习: 结合\n(换行)，\t(制表符)，空格等在控制台打印出心形图案所示的效果。
 *
 * @author hfm
 * @version 1.01 2020-03-18 19:01
 * @date 2020/3/18
 */
public class PrintHeartShaped {
    public static void main(String[] args) {
        way1();
        way2();
    }

    /**
     * 打印心形方法 2
     */
    private static void way2() {
        System.out.print("\t");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("I love java");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("\t");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.println("*");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("\t");
        System.out.print("    ");
        System.out.print("*");
    }

    /**
     * 打印心形方法一
     */
    private static void way1() {
        System.out.print("\t" + "*" + "\t\t\t\t\t\t\t\t\t\t\t\t" + "*" + "\t" + "\n");
        System.out.print("*" + "\t\t" + "*" + "\t\t\t\t" + "I love Java" + "\t\t\t\t" + "*" + "\t\t" + "*" + "\n");
        System.out.print("\t" + "*" + "\t\t\t\t\t\t\t\t\t\t\t\t" + "*" + "\t" + "\n");
        System.out.print("\t\t" + "*" + "\t\t\t\t\t\t\t\t\t\t" + "*" + "\t\t" + "\n");
        System.out.print("\t\t\t" + "*" + "\t\t\t\t\t\t\t\t" + "*" + "\t" + "\n");
        System.out.print("\t\t\t\t" + "*" + "\t\t\t\t\t\t" + "*" + "" + "\t" + "\n");
        System.out.print("\t\t\t\t\t" + "*" + "\t\t\t\t" + "*" + "" + "\t\t" + "\n");
        System.out.print("\t\t\t\t\t\t" + "*" + "\t\t" + "*" + "" + "\t\t" + "\n");
        System.out.print("\t\t\t\t\t\t\t" + "*" + "\n");
    }
}
