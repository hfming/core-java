package com.hfm.sort.integer;

/**
 * 归并排序
 *
 * @author shkstart
 * 2018-12-17
 */
public class MergeSort {

    public static void mergeSort(int[] data,int left, int right ){
        if (left < right) {
            //找出中间索引
            int center = (left + right) / 2;
            mergeSort(data, left, center);
            mergeSort(data, center + 1, right);
            //合并
            merge(data, left, center, right);
        }
    }

    /**
     * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
     *
     * @param data   待排数组
     * @param left   左指针
     * @param center 中间指针
     * @param right  右指针
     */
    private static void merge(int[] data, int left, int center, int right) {
        int[] tempArr = new int[data.length];
        int mid = center + 1;
        int third = left;
        int temp = left;
        while (left <= center && mid <= right) {
            if (data[left] - data[mid] <= 0) {
                // 取小排序
                tempArr[third++] = data[left++];
            } else {
                tempArr[third++] = data[mid++];
            }
        }
        while (mid <= right) {
            tempArr[third++] = data[mid++];
        }
        while (left <= center) {
            tempArr[third++] = data[left++];
        }
        while (temp <= right) {
            data[temp] = tempArr[temp++];
        }
    }

    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        mergeSort(data,0,data.length-1);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));


    }
}
