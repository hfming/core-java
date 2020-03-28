package com.hfm.baisc;

import java.util.Arrays;

/**
 * 练习:输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
 *
 * @author hfm
 * @version 1.01 2020-03-19 19:34
 * @date 2020/3/19
 */
public class ChangeArray {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 12, 34, 45, 67, 53, 76, 34};
        changeArr(arr);
    }

    private static void changeArr(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        // 获取最大及最小值
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int minNum = 0;
        int maxNum = 0;
        // 获取最大值与最小值网址
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                maxNum = i;
            }
            if (arr[i] == min) {
                minNum = i;
            }
        }

        //System.out.println(maxNum+" "+minNum);
        //System.out.println(max+" "+min);

        int temp = 0;
        temp = arr[0];
        arr[0] = arr[maxNum];
        arr[maxNum] = temp;

        temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[minNum];
        arr[minNum] = temp;

        System.out.println(Arrays.toString(arr));
    }
}
