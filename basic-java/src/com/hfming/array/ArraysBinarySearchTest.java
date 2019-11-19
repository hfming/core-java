package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.binarySearch( ) 方法测试
 * 
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysBinarySearchTest {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 8, 9, 6, 7, 1, 2, 3 };
        
        // 遍历数组
        System.out.println(Arrays.toString(arr));// [5, 4, 8, 9, 6, 7, 1, 2, 3]
        
        // 数组升序排列
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        // 查找4在当前数组中的位置，使用二分法查找
        System.out.println(Arrays.binarySearch(arr, 4));
    }
}