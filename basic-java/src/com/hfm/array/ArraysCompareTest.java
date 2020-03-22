package com.hfm.array;

import java.util.Arrays;

/**
 * Arrays.compare() 与 Arrays.compareUnsigned() Demo
 *
 * 如果第一和第二数组相等并且包含相同顺序的相同元素，则值为0；如果第一个数组在字典上小于第二个数组，则该值小于0；如果第一个数组在字典上大于第二个数组，则该值大于0
 * @author hfm
 * @version 1.1 2020-02-29
 */
public class ArraysCompareTest {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr2[] = {1, 2, 3, 4, 4, 6, 7, 8, 9};

        // 0
        System.out.println(Arrays.compare(arr2, arr2));
        // 1
        System.out.println(Arrays.compare(arr1,arr2));
        // -1
        System.out.println(Arrays.compare(arr2,arr1));

        // 0
        System.out.println(Arrays.compareUnsigned(arr1,arr1));
        // 1
        System.out.println(Arrays.compareUnsigned(arr1,arr2));
        // -1
        System.out.println(Arrays.compareUnsigned(arr2,arr1));

        int arr3[] = {1, 2, 3, 9};
        int arr4[] = {1, 2, 3, 4};

        System.out.println(Arrays.compare(arr3, arr4));
        System.out.println(Arrays.compare(arr4, arr3));
        System.out.println(Arrays.compareUnsigned(arr3, arr4));
        System.out.println(Arrays.compareUnsigned(arr4, arr3));
    }
}
