package com.hfming.controlprocess;

import java.util.Random;
import java.util.Scanner;

/**
 * while循环语句的使用
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class While {
    public static void main(String[] args) {

        // 需求：需要打印一行字符串"hello gzitcast"，100 次
        int i = 0;
        while (i < 100) {
            System.out.println(i);
            i++;
        }

        // 练习：想要打印出 1-100 之间的奇数
        i = 1;
        while (i <= 100) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
            i++;
        }

        // 练习 2：计算 1+2+3+4+5+6+7+8+9 的值
        i = 1;
        int sum = 0;
        while (i <= 9) {
            sum += i;
            i++;
        }

        /*
         * 注意：要精确控制循环的次数。常犯错误是是循环多执行一次或者少执行一次。 例如会执行 101 次，想要执行 100 次，要么是 count 初始值为
         * 1，然后 count<=100 要么是 count 初始值为 0，coung<100
         */
        /*
         * 猜数字游戏:编写程序随即生成一个 0-100
         * 之间的随机数。程序提示用户输入一个数字，不停猜测，直到猜对为止。最后输出猜测的数字，和猜测的次数。并且如果没有猜中要提示用户输入的值是大了还是小了。
         * 思考：如何生成 1-100 之间随机数？
         */
        // 首先程序生成了一个随机数
        int num = (int) (Math.random() * 100) + 1;
        // 用户输入一个数字
        Scanner sc = new Scanner(System.in);
        int guessNum = -1;
        // 循环检查用户数字和随机数是否相同，知道相同位置，循环结束
        while (guessNum != num) {
            System.out.println("请输入1-100之间整数");
            guessNum = sc.nextInt();
            if (guessNum == num) {
                System.out.println("中啦");
            } else if (guessNum < num) {
                System.out.println("小啦");
            } else {
                System.out.println("大了");
            }
        }
        Random random = new Random();
        int num1 = random.nextInt(11);
    }
}
