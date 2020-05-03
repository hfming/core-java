package com.hfm.commonexception;

import java.util.Scanner;

/**
 * @author hfm
 * @version 1.01 2020-04-16 1:57
 * @date 2020/4/16
 */
public class InputMismatchExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int in = scanner.nextInt();
    }
}
