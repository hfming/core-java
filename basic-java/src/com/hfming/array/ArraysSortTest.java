package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.parallelSort( ) 与 Arrays.sort()方法
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysSortTest {
    public static void main(String[] args) {
        int[] arr1=new int[]{1,8,51,13,46,11,22};
        
        // 对数组进行并发排序
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        
        // 双轴快排
        arr1=new int[]{1,8,51,13,46,11,22};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
