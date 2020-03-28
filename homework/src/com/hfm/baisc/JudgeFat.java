package com.hfm.baisc;

import java.util.Scanner;

/**
 * 练习:开发一款软件，根据公式（身高-108）*2=体重，可以有10斤左右的浮动。来观察测试者体重是否合适。
 *
 * @author hfm
 * @version 1.01 2020-03-19 13:48
 * @date 2020/3/19
 */
public class JudgeFat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入体重");
        int weigth = scanner.nextInt();
        System.out.println("输入的体重为" + weigth);
        System.out.println("请输入身高");
        int heigth = scanner.nextInt();
        System.out.println("输入的身高为" + heigth);
        if (Math.abs((heigth - 108) * 2 - weigth) < 10) {
            System.out.println("测试者体重合适");
        }else{
            System.out.println("测试者体重不合适");
        }
    }
}
