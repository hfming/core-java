package com.hfm.baisc;

import java.util.Scanner;

/**
 * 联系 判断一个整数是偶数还是奇数
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class JudgingNumbers {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要判断的整数");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println("输入的" + num + "是偶数");
        } else {
            System.out.println("输入的" + num + "是奇数");
        }
    }
}
