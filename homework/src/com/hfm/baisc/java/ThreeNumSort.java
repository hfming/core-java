package com.hfm.baisc.java;

import java.util.Arrays;

/**
 * 练习: 实现对三个整数进行排序，输出时按照从小到大的顺序输出。
 *
 * @author hfm
 * @version 1.01 2020-03-18 22:52
 * @date 2020/3/18
 */
public class ThreeNumSort {
    public static void main(String[] args) {
        int[] arr = new int[]{232, 454, 29,34323,4545,4542,3235,232};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
