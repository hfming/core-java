package com.hfm.sort.integer;

/**
 * 直接选择排序
 *
 * @author shkstart
 * 2018-12-17
 */
public class SelectSort {
    public static void selectSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (data[i] - data[j] > 0) {
                    swap(data, i, j);
                }
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 选择排序优化
     *
     * @param data
     */
    public static void selectSort2(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (data[minIndex] - data[j] > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
            System.out.println(java.util.Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        selectSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
