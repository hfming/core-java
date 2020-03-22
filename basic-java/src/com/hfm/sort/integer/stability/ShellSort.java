package com.hfm.sort.integer.stability;

/**
 * Shell排序
 *
 * @author shkstart
 * 2018-12-17
 */

public class ShellSort {
    public static void ShellSort(int[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;

        int h = 1;
        while (h <= arrayLength / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("===h的值：" + h + "===");
            for (int i = h; i < arrayLength; i++) {
                int temp = data[i];
                if (data[i] - data[i - h] < 0) {
                    int j = i - h;
                    for (; j >= 0 && data[j] - temp > 0; j -= h) {
                        data[j + h] = data[j];
                    }
                    data[j + h] = temp;
                }
                System.out.println(java.util.Arrays.toString(data));
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // 逐步减少间隔数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                //插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    // 待插入的数
                    int value = arr[j];
                    // 待插入的序列
                    int num = j;
                    // 如果arr[i]比前一位要低要将前一位的值赋值给后一位，直到arr[i]的值与前一位相同或大于时
                    while (num >= gap  && value < arr[num - gap]) {
                        arr[num] = arr[num - gap];
                        num -= gap;
                    }
                    // 最后将arr[i]的值赋值给最前的位
                    arr[num] = value;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30,232,545,4,232,32,32,3,232,323232,323,232443,4};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        shellSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
