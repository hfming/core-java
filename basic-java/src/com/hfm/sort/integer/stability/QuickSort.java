package com.hfm.sort.integer.stability;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 *
 * @author shkstart
 * 2018-12-17
 */
public class QuickSort {


    private static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                // 从左边开始寻找比基准数小的数
                while (low < end && data[++low] <= base) {

                }
                // 从右边开始寻找比基准数大的数
                while (high > start && data[--high] >= base) {

                }
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high);

            // 递归调用
            subSort(data, start, high - 1);
            subSort(data, high + 1, end);
        }
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 判断输入的数组长度不为1
        if (left < right) {
            // 选取数组最左边的数作为基准数
            int base = arr[left];
            // 将数组left 与right赋值给变量
            int low = left;
            int high = right;

            // 到 low == high  结束
            while (low < high) {
                // 从右边开始寻找比基准数小的值, 找到了就进行交换
                while (arr[high] >= base && low < high) {
                    high--;
                }
                if (low < high && arr[high] <= base) {
                    swap(arr, low, high);
                }

                // 从左边开始找比基准数大的值, 找到了就进行交换
                while (arr[low] <= base && low < high) {
                    low++;
                }
                if (low < high && arr[low] >= base) {
                    swap(arr, low, high);
                }
            }
            // 递归调用，分治
            quickSort(arr, left, low - 1);
            quickSort(arr, low + 1, right);
        }
    }


    public static void main(String[] args) {
        int[] data = {9, -16, 30, 23, -30, -49, 25, 21, 30};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
