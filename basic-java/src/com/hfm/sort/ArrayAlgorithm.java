package com.hfm.sort;

import java.util.Scanner;

/**
 * 数组常用算法
 *
 * @author hfm
 */
public class ArrayAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数字");
        int len = scanner.nextInt();
        int[][] arr = new int[len][len];
        int s = len * len;
        /*
         * k = 1:向右 k = 2:向下 k = 3:向左 k = 4:向上
         */
        int k = 1;
        int i = 0, j = 0;
        for (int m = 1; m <= s; m++) {
            if (k == 1) {
                if (j < len && arr[i][j] == 0) {
                    arr[i][j++] = m;
                } else {
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            } else if (k == 2) {
                if (i < len && arr[i][j] == 0) {
                    arr[i++][j] = m;
                } else {
                    k = 3;
                    i--;
                    j--;
                    m--;
                }
            } else if (k == 3) {
                if (j >= 0 && arr[i][j] == 0) {
                    arr[i][j--] = m;
                } else {
                    k = 4;
                    i--;
                    j++;
                    m--;
                }
            } else if (k == 4) {
                if (i >= 0 && arr[i][j] == 0) {
                    arr[i--][j] = m;
                } else {
                    k = 1;
                    i++;
                    j++;
                    m--;
                }
            }
        }
        // 遍历
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[m].length; n++) {
                System.out.print(arr[m][n] + "\t");
            }
            System.out.println();
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
