package com.hfm.sort;

import java.util.Arrays;

/**
 * 快速排序法
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class QuickSort {
    /**
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 选取数组最左边的数作为基准数
        int index = arr[left];

        // 判断输入的数组长度不为1
        if (left < right) {
            // 将数组left 与right赋值给变量
            int i = left;
            int j = right;
            //
            while (i < j) {
                // 创建局部变量存储数据，用于交换
                int temp;
                //如果找到的值大于基数值，那么继续往下找
                while (arr[j] >= index && i < j) {
                    j--;
                }
                //如果找到的值小于基数值，那么进行值交换
                if (i < j && arr[j] <= index) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                //如果找到的值小于基数值，那么继续往下找
                while (arr[i] <= index && i < j) {
                    // 到 i == j 结束
                    i++;
                }
                //如果找到的值大于基数值，那么进行值交换
                if (i < j && arr[i] >= index) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // i == j

            // 递归调用，分治
            quickSort(arr, left, i - 1);
            // 递归调用，分治
            quickSort(arr, i + 1, right);
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort2(int[] arr, int left, int right) {
        int i = left + 1;
        int pivot = arr[left];
        int j = right;
        //判断是否是一个数的分区,如果不是继续运行
        if (left < right) {
            while (i < j) {
                //如果arr[i]比基准数大，arr[i]与最后位互换
                if (arr[i] > pivot) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--;
                } else {
                    i++;
                }
            }
            // 基准数与分区最后一位进行比较
            if (arr[i] >= arr[left]) {
                i--;
            }
            int temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
            //再次分区运算
            quickSort2(arr, left, i);
            quickSort2(arr, j, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9, 4, 4};
        // 调用排序算法进行排序
        quickSort(arr, 0, arr.length - 1);
        // 输出数组
        System.out.println(Arrays.toString(arr));

        //quickSort2(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
    }
}
