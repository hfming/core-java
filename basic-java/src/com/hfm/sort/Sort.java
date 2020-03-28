package com.hfm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 数组常用算法
 *
 * @author hfm
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = new int[]{43, 434, 34, 32, 454, 454, 56, 98, 0};
        System.out.println(Arrays.toString(reverseArray(a)));
        // 数组工具类的使用
        System.out.println(Arrays.toString(reverseArray(a)));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 34));
        int oldArr[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(clearZero(oldArr)));

        int[] arr = {1, 4, 4, 1, 1, 7};
        System.out.println(Arrays.toString(clearRepetition(arr)));
        int[][] arg = {{2, 2}, {3, 3}, {5, 45, 65, 5}};
        toStringTwoDimensionalArray(arg);
        System.out.println();
        System.out.println(getSumTwoDimensionalArray(arg));
        System.out.println(getTwoDimensionalArrayNum(arg));
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
        // 获取数组中最长元素长度
        int maxL = String.valueOf(max).length();

        int k = new Double(Math.pow(10, maxL - 1)).intValue();
        // 桶
        int[][] t = new int[10][n];
        // 记录每个桶中存入数的个数
        int[] num = new int[n];
        // 按最高位入桶
        for (int a : arr) {
            int m = (a / k) % 10;
            t[m][num[m]] = a;
            num[m]++;
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            // 如果桶中只有一个数则直接取出
            if (num[i] == 1) {
                arr[c++] = t[i][0];
                // 如果桶中不止一个数，则另存如数组B递归
            } else if (num[i] > 1) {
                int[] B = new int[num[i]];
                for (int j = 0; j < num[i]; j++) {
                    B[j] = t[i][j];
                    // 递归方法
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
        // 中间数组长度// 中间数组长度
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

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int value = arr[i];
            // 待插入的序列
            int num = i;
            // 如果arr[i]比前一位要低要将前一位的值赋值给后一位，直到arr[i]的值与前一位相同或大于时
            while (num > 0 && value < arr[num - 1]) {
                arr[num] = arr[num - 1];
                num--;
            }
            // 最后将arr[i]的值赋值给最前的位
            arr[num] = value;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            // -x:让每次参与比较的元减。//-1:避免角标越界。
            for (int y = 0; y < arr.length - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序（快速排序）
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // 为什么y的初始化值是 x+1？  因为每一次比较，
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                // 都用x角标上的元素和下一个元素进  行比较。
                if (arr[x] > arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }

    /**
     * 二分法
     *
     * @param arr
     * @param key
     * @return
     */
    public static int halfSeach(int[] arr, int key) {
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }
            if (min > max) {
                return -1;
            }
            mid = (max + min) / 2;
        }
        return mid;
    }

    /**
     * 数组翻转
     */
    private static int[] reverseArray(int[] arg) {
        for (int start = 0, end = arg.length - 1; start < end; start++, end--) {
            int temp = arg[start];
            arg[start] = arg[end];
            arg[end] = temp;
        }
        // System.out.println(Arrays.toString(arg));
        return arg;
    }


    /**
     * 二维数组
     *
     * @param arg
     */
    private static void twoDimensionalArray(int[][] arg) {
        System.out.println(arg.length);
        System.out.println(arg[0].length);
    }


    /**
     * 遍历二维数组
     *
     * @param arg
     */
    private static void toStringTwoDimensionalArray(int[][] arg) {
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                if (j == 0) {
                    System.out.print("[" + arg[i][j] + ",");
                } else if (j == arg[i].length - 1) {
                    System.out.print(arg[i][j] + "]");
                } else {
                    System.out.print(arg[i][j] + ",");
                }
            }
        }
    }


    /**
     * 对二维数组求和
     *
     * @param arg
     * @return
     */
    private static int getSumTwoDimensionalArray(int[][] arg) {
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                sum += arg[i][j];
            }
        }
        return sum;
    }

    /**
     * 统计二维数组中元素的个数
     *
     * @param arg
     * @return
     */
    private static int getTwoDimensionalArrayNum(int[][] arg) {
        int count = 0;
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[i].length; j++) {
                count++;
            }
        }
        return count;
    }


    /**
     * 现在有如下的一个数组：int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ，
     *
     * @param arg
     * @return
     */
    private static int[] clearZero(int[] arg) {
        //统计0的个数
        int count = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] == 0) {
                count++;
            }
        }

        int[] result = new int[arg.length - count];
        int num = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] != 0) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }


    /**
     * 清除重复元素。 int[] oldArr = {1,4，9,4,1,1,7}； 把非重复元素存储到一个新的数组中返回，而且也是不能浪费长度
     *
     * @param arg
     * @return
     */
    private static int[] clearRepetition(int[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    //重复的只统计一次
                    break;
                }
            }
        }
        int[] result = new int[arg.length - count];
        System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

}
