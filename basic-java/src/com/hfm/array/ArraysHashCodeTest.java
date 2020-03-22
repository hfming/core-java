package com.hfm.array;

import java.util.Arrays;

/**
 * Arrays.hashCode( ) 和 Arrays.deepHashCode( ) 方法 测试
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class ArraysHashCodeTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 3, 3};
        int[] arr3 = new int[]{4, 3, 2, 1};
        int[][] arr4 = new int[][]{arr1, arr2, arr3};
        int[][] arr5 = new int[][]{{1, 2, 3}, arr2};

        // 一维数组使用 hashCode() 计算哈希值
        System.out.println(Arrays.hashCode(arr1));
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.hashCode(arr3));

        // 多维数组使用 hashCode() 计算哈希值 不会报错
        System.out.println(Arrays.hashCode(arr4));
        System.out.println(Arrays.hashCode(arr5));

        // 多维数组使用 deepHashCode() 方法
        System.out.println(Arrays.deepHashCode(arr4));
        System.out.println(Arrays.deepHashCode(arr5));
    }
}
