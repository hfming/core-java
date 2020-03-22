package com.hfm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 8种经典算法
 *
 * @author hfm
 */
public class ClassicalSottingAlgorithms {
    public static void main(String[] args) {
        int[] a = new int[]{43, 434, 34, 32, 454, 454, 56, 98, 0};
        // System.out.println(Arrays.toString(insertionSort(a)));
        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    /**
     * 插入排序
     *
     * @param a
     * @return
     */
    public static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // 第i+1个元素插入到前i个已排序数中
            /*
             *	i=0,j=1,a[0]与a[1]进行对比大小
             *	i=1,j=2,a[1]与a[2]进行对比大小
             */
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }


    /**
     * 选择排序
     *
     * @param a
     * @param n
     * @return
     */
    public static int[] selectionSort(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            //每次循环默认第i个元素为最小值
            int min = a[i];
            //num 用来记录未排序元素里面的最小值下标
            int num = i;
            /*
             *  i=0,min=a[0],num=0,j=1,a[1]与a[0]进行对比
             *  i=0,min=a[0],num=0,j=2,a[2]与a[0]进行对比
             */
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    num = j;
                }
            }
            // num != i，则表示已在无排序元素里选到比a[i]更小的值
            if (num != i) {
                a[num] = a[i];
                a[i] = min;
            }
        }
        return a;
    }

    /**
     * 冒泡排序
     */
    private static int[] bubbleSort(int[] arg) {
        /*
         * i=0,j=0,arg[0]与arg[1]比较大小
         * i=0,j=1,arg[1]与arg[2]比较大小
         * i=0,j=2,arg[2]与arg[3]比较大小
         * i=1,j=0,arg[0]与arg[1]
         */
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = 0; j < arg.length - i - 1; j++) {
                if (arg[j] >= arg[j + 1]) {
                    int temp = arg[j];
                    arg[j] = arg[j + 1];
                    arg[j + 1] = temp;
                }
            }
        }
        return arg;
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public void radixSort(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        double d = Math.pow(10, String.valueOf(max).length());
        int k = 1;
        // 桶
        int[][] t = new int[10][n];
        // 记录每个桶中存入数的个数
        int[] num = new int[n];
        while (k < d) {
            for (int a : arr) {
                int m = (a / k) % 10;
                t[m][num[m]] = a;
                num[m]++;
            }
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (num[i] != 0) {
                    for (int j = 0; j < num[i]; j++) {
                        arr[c++] = t[i][j];
                    }
                }
                num[i] = 0;
            }
            k = k * 10;
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     * @param n
     * @return
     */
    public static int[] MSDSort(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //获取数组中最长元素长度
        int maxL = String.valueOf(max).length();

        int k = new Double(Math.pow(10, maxL - 1)).intValue();
        //桶
        int[][] t = new int[10][n];
        //记录每个桶中存入数的个数
        int[] num = new int[n];
        //按最高位入桶
        for (int a : arr) {
            int m = (a / k) % 10;
            t[m][num[m]] = a;
            num[m]++;
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            //如果桶中只有一个数则直接取出
            if (num[i] == 1) {
                arr[c++] = t[i][0];
                //如果桶中不止一个数，则另存如数组B递归
            } else if (num[i] > 1) {
                int[] B = new int[num[i]];
                for (int j = 0; j < num[i]; j++) {
                    B[j] = t[i][j];
                    //递归方法
                    MSDSort(B, num[i]);
                }
            }
        }
        return arr;
    }

    /**
     * 桶排序
     *
     * @param arr
     * @return
     */
    public static ArrayList BucketSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        // 获取最大与最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 桶个数
        int bucketNum = (max - min) / arr.length + 1;
        // 构造桶
        // 创建桶用于存储元素
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        // 桶初始化
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将每个元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        return bucketArr;
    }

    /**
     * 计数排序
     *
     * @param arr
     * @param back
     * @param
     */
    public static void countingSort(int[] arr, int[] back) {
        int max = 0;
        // 获取最大值
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 建立数组存放数组中每个值为i的元素的出现的次数
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }
        // 对所有的计数累加；
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        // 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
        for (int i = arr.length - 1; i >= 0; i--) {
            count[arr[i]]--;
            back[count[arr[i]]] = arr[i];
        }
    }

    /**
     * 递归分治
     *
     * @param arr   待排数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void mSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 递归排序左边
            mSort(arr, left, mid);
            // 递归排序右边
            mSort(arr, mid + 1, right);
            // 合并
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param arr   待合并数组
     * @param left  左指针
     * @param mid   中间指针
     * @param right 右指针
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 中间数组长度
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 边界
        while (i <= j && j <= right) {
            // 取小排序
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int p = 0; p < k; p++) {
            arr[left + p] = temp[p];
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
                // 插入排序
                for (int j = i + gap; j < arr.length; j += gap) {
                    for (int k = j - gap; k >= i
                            && arr[k] > arr[k + 1]; k -= gap) {
                        int temp = arr[k + 1];
                        arr[k + 1] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
    }
    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        int i = left + 1;
        int pivot = arr[left];
        int j = right;
        // 判断是否是一个数的分区,如果不是继续运行
        if (left < right) {
            while (i < j) {
                // 如果arr[i]比基准数大，arr[i]与最后位互换
                if (arr[i] > pivot) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--;
                } else {
                    i++;
                }
            }
            // !!!注意
            if (arr[i] >= arr[left]) {
                i--;
            }
            int temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
            // 再次分区运算
            // 左区
            quickSort(arr, left, i);
            // 右区
            quickSort(arr, j, right);
        }
    }
}
