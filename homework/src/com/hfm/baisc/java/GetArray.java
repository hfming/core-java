package com.hfm.baisc.java;

/**
 * 练习 对于一个int数组，把其中的所有元素都向后移动一个位置定义一个长度为10的int数组,统计数组的最大值、最小值、奇数和偶数的个数
 * 比如： int[] arr = { 1, 3, 5, 7, 9 }  --> { 9, 1, 3, 5, 7 }
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 4, 34356, 5675};
        int max = arr[0];
        int min = arr[0];
        int oddNum = 0;
        int evenNum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("最小值为：" + min);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                oddNum++;
            }
        }
        System.out.println("奇数个数为:" + oddNum);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenNum++;
            }
        }
        System.out.println("偶数个数为:" + evenNum);
    }
}
