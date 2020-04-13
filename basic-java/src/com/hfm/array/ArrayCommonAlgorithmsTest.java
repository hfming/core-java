package com.hfm.array;

/**
 * 数组常见算法 Demo
 *
 * @author hfm
 * @version 1.1 2020-03-03
 */
public class ArrayCommonAlgorithmsTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 10, 6, 89, 47};
        arrayFlip(arr);
    }

    /**
     * 数组翻转
     *
     * @param arr
     */
    public static void arrayFlip(int[] arr) {
        int temp = 0;
        for (int min = 0, max = arr.length - 1; min < max; min++, max--) {
            temp = 0;
            temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        // 反转后，遍历数组
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 数组最大值
     *
     * @param array
     * @return
     */
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前元素，比max更大，则换人
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 数组最小值
     *
     * @param array
     * @return
     */
    public static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前元素，比max更大，则换人
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
