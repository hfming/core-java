package com.hfm.array;

/**
 * 数组工具类
 * 功能：除去数组中为0的元素，返回新的数组
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class ArrayRemoveZero {
    public static int[] arrayRemoveZreo(int[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        int[] newArray = new int[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }
}
