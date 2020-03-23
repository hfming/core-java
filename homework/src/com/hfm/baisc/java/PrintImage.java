package com.hfm.baisc.java;

/**
 * 练习:在屏幕上输出一个n行的金字塔图案，例如，若n=4,则图案如下
 * *
 * ***
 * *****
 * *******
 * 练习:输入长和宽，输出长方形，如：输入4和3, 将输出如下图形
 * ####
 * ####
 * ####
 * 练习:输入高度，输出直角三角形。如：输入4, 将输出如下图形
 * #
 * ##
 * ###
 * ####
 * 练习:输入高度，输出倒直角三角形。如：输入4, 将输出如下图形
 * ####
 * ###
 * ##
 * #
 * 练习:打印如下的图形：三角形
 * *
 * * * *
 * * * * * *
 * * * * * * * *
 * * * * * *
 * * * *
 * *
 *
 * @author hfm
 * @version 1.01 2020-03-19
 * @date 2020/3/19
 */
public class PrintImage {
    public static void main(String[] args) {
        //print1();
        //print2();
        //print3();
        //print4();
        //print5();
        //print6();
        //print6();
        //print8();

    }

    private static void print8() {
        System.out.println("      ******       ******          \n" +
                "    **********   **********         \n" +
                "  ************* *************\t\t\n" +
                " *****************************     \n" +
                " *****************************     \n" +
                " *****************************\t   \n" +
                "  ***************************       \n" +
                "    ***********************         \n" +
                "      *******************          \n" +
                "        ***************             \n" +
                "          ***********             \n" +
                "            *******                \n" +
                "              ***                  \n" +
                "               *    \n");
    }

    private static void print7() {
        System.out.println("**********        \n" +
                "****  ****        \n" +
                "***    ***        \n" +
                "**      **        \n" +
                "*        *        \n" +
                "**      **\n" +
                "***    ***\n" +
                "****  ****\n" +
                "**********\n");
    }

    private static void print6() {
        for (int i = 0; i < 5; i++) {
            // 输出“-”
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            // 输出“* ”
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // 下半部分
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 4 - i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void print5() {
        for (int i = 0; i < 7; i++) {
            if (i < 4) {
                for (int j = 0; j < 2 * i + 1; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int k = 0; k < 13 - 2 * i; k++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    private static void print4() {
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void print3() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void print2() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void print1() {
        String str1 = " ";
        String str2 = "*";
        for (int i1 = 0; i1 < 10; i1++) {
            for (int j1 = 0; j1 < 10 - i1; j1++) {
                System.out.print(str1);
            }
            for (int k1 = 0; k1 < i1 * 2 - 1; k1++) {
                System.out.print(str2);
            }
            System.out.println();
        }
    }
}
