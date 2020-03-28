package com.hfm.baisc;

import java.util.Arrays;

/**
 * 练习 请编写程序输出九九乘法表
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};

        System.out.println(Arrays.deepToString(arr));
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[arr.length - 1 - i][j];
                arr[arr.length - 1 - i][j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0 || i == arr.length - 1 || j == arr[i].length - 1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j < i) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == i) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        int [] newArr = new int[arr.length];
        int max;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if(max < arr[i][j]){
                    max = arr[i][j];
                }
            }
            newArr[i] = max;
        }
        System.out.println(Arrays.toString(newArr));

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
