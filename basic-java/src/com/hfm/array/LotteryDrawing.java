package com.hfm.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 彩票抽奖。
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("您需要画多少个数字？");
        int k = in.nextInt();

        System.out.print("您最多可以画几张？");
        int n = in.nextInt();

        // 填充数组
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // 画出k个数字并将其放入第二个数组
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // 在0到n-1之间建立随机索引
            int r = (int) (Math.random() * n);

            // 在随机位置选择元素
            result[i] = numbers[r];

            // 将最后一个元素移到随机位置
            numbers[r] = numbers[n - 1];
            n--;
        }

        // 打印排序的数组
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for (int r : result) {
            System.out.println(r);
        }
    }
}
