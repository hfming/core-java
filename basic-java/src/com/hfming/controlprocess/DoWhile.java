package com.hfming.controlprocess;

import java.util.Random;
import java.util.Scanner;

/**
 * DoWhile 语句
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class DoWhile {
    public static void main(String[] args) {
        Random random = new Random();
        // 改写猜数字游戏
        // 记录用户输入的数字
        int guess = -1;
        // 记录用户输入次数
        int count = 0;
        // 生成1-100之间随机数
        int num11 = (int) (int) (Math.random() * 100) + 1;
        Scanner sc1 = new Scanner(System.in);
        // 循环猜数字
        do {
            System.out.println("请输入1-100之间的数字");
            guess = sc1.nextInt();
            if (guess > num11) {
                System.out.println("哥们，太大了");
            } else if (guess < num11) {
                System.out.println("哥们，太小了");
            } else {
                System.out.println("恭喜，中啦");
            }
            count++;
        } while (num11 != guess);
        System.out.println("你猜测的数字是:" + num11 + "猜测了" + count + "次");

        // 计算器
        // 系统自动生成 2 个随机数用于参与运算。
        // 系统生成 0-4 之间的随机数，表示加减乘除取模运算。
        do {
            int a = random.nextInt(10) + 1;
            // 注意除数为 0 的情况
            int b = random.nextInt(10) + 1;
            int c = random.nextInt(4);
            switch (c) {
                case 0:
                    System.out.println(a + b);
                    break;
                case 1:
                    System.out.println(a - b);
                    break;
                case 2:
                    System.out.println(a * b);
                    break;
                case 3:
                    System.out.println(a / b);
                    break;
                case 4:
                    System.out.println(a % b);
                    break;
                default:
                    System.out.println("a=" + a + " b=" + b);
                    break;
            }
        } while (true);
    }
}
