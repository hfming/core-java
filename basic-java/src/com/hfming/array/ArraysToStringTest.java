package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.toString( ) 与 Arrays.deepToString( ) 方法测试
 * 
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysToStringTest {
    public static void main(String[] args) {
        // 定义一个数组
        int[] arr = { 24, 69, 80, 57, 13 };
       
        // public static String toString(int[] a) 把数组转成字符串
        System.out.println("排序前：" + Arrays.toString(arr));
        
        // public static void sort(int[] a) 对数组进行排序
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        
        // [13, 24, 57, 69, 80]
        // public static int binarySearch(int[] a,int key) 二分查找
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 57));
        System.out.println("binarySearch:" + Arrays.binarySearch(arr, 577));
    
        // Arrays.deepToString() 方法
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,3,3};
        int[] arr3 = new int[]{4,3,2,1};
        int[][] arr4  = new int[][]{arr1,arr2,arr3};
        System.out.println(Arrays.toString(arr1));
        // 输出第一层的引用类型变量地址 [[I@383534aa, [I@6bc168e5, [I@7b3300e5]
        System.out.println(Arrays.toString(arr4));
        
        // Arrays.deepToString() 只能使用在多维数组中
        ///System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr4));
    }
}
