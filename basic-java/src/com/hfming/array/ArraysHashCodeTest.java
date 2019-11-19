package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.hashCode( ) 和 Arrays.deepHashCode( ) 方法 测试
 * 
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysHashCodeTest {
    public static void main(String[] args) {
        int[] arr1= new int[]{1,2,3};
        int[] arr2 = new int[]{1,3,3};
        int[] arr3 = new int[]{4,3,2,1};
        int[][] arr4 = new int[][]{arr1,arr2,arr3};
        int[][] arr5 = new int[][]{{1,2,3},arr2};
        
        // arr1的第一层为1，2，3的hashCode
        System.out.println(Arrays.hashCode(arr1));
        // arr4的第一层为引用类型变量
        System.out.println(Arrays.hashCode(arr4));
        System.out.println(Arrays.hashCode(arr4) == Arrays.hashCode(arr1));
        
        System.out.println(Arrays.deepHashCode(arr4));
    }
}
