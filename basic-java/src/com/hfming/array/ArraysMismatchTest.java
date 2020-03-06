package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.mismath() Demo
 *
 * @author hfm
 * @version 1.1 2020-02-29
 */
public class ArraysMismatchTest {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {1, 2, 5, 4, 5, 6};

        // 查找两个数组之间第一个不同元素的位置
        System.out.println(Arrays.mismatch(arr1, arr2));
        // 在规定范围内查找两个数组之间第一个不同元素的位置
        System.out.println(Arrays.mismatch(arr1, 1, 4, arr2, 3, 6));
    }
}
