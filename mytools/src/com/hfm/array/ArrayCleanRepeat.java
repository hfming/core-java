package com.hfm.array;

/**
 * 数组工具类
 * 功能：去除重复元素，返回新的数组
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class ArrayCleanRepeat {
    public static int[] arrayCleanRepeat(int[] arr) {
        // 统计重复元素的个数
        int repeatNumber = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    repeatNumber++;
                    break;
                }
            }
        }
        //创建新的数组
        int[] arr2 = new int[arr.length - repeatNumber];
        int index = 0;
        OUT:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == arr[i]) {
                    continue OUT;
                }
            }
            arr2[index] = arr[i];
            index++;
        }
        return arr2;
    }
}
