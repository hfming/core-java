package com.hfm.valuepass;

import java.util.Arrays;

/**
 * 数组数据类型值交换
 *
 * @author hfm
 * @version 1.01 2020-03-27 16:11
 * @date 2020/3/27
 */
public class ArrayExchangeValue {
    public static void main(String[] args) {
        int[] arr1 = new int[]{34, 54, 54};
        int[] arr2 = new int[]{65, 63, 32};
        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));

        exchangeArrayValue(arr1, arr2);
        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));

        // 中间值法交换
        int[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;
        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));

        // 交换失败，仅仅是形参进行交换
        exchange(arr1,arr2);
        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));

        char[] ch = {'A', 'v', ',', 'i', 'l', 'o', 'v', 'e'};
        System.out.println(ch);
    }

    /**
     * 数组变量进行交换，交换成功，操作的是同一个数组对象
     *
     * @param arr1
     * @param arr2
     */
    public static void exchangeArrayValue(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("数组长度不统一，无法进行交换!");
        } else {
            for (int i = 0; i < arr1.length; i++) {
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            }
        }
    }

    public static void exchange(int[] arr1, int[] arr2){
        int[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;
    }
}
