package com.hfming.baiscjava;

import java.util.Scanner;

/**
 * 练习 给定3个数a，b和c,输出最大的数。
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class GetBiggest {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入三个数并用“，”号隔开");
        String str = scanner.next();
        // 将输入的字符串切割开
        String[] arr = str.split(",");
        int[] arr2 = new int[arr.length];
        // 将字符串转发为数字
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }
        // 选出最大的数字
        int max = arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        System.out.println("输入的三个数字中最大的为" + max);
    }
}
