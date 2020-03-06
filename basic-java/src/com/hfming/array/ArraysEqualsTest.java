package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.equals( ) 与Arrays.deepEqual( ) Demo
 *
 * @author hfm
 * @version 1.2 2020-02-29
 */
public class ArraysEqualsTest {
    public static void main(String[] args) {
        // Arrays.equals( )
        String[] array = new String[]{"a", "c", "2", "1", "b"};
        String[] array2 = new String[]{"z", "c", "2", "1", "b"};

        // 1.对比引用是否相同
        // 2.对比是否存在null
        // 3.对比长度是否相同
        // 4.挨个元素对比
        System.out.println(Arrays.equals(array, array2));
        System.err.println(array == array2);

        // Arrays.deepEqual()
        String[][] array3 = new String[][]{{"1", "2"}, {}, {}};
        String[][] array4 = new String[][]{{}, {}, {"3", "4"}};
        String[][] array5 = new String[][]{{}, {}, {"3", "4"}, {"1", "2"}};

        // 深度比较两个数组是否相同
        System.out.println(Arrays.deepEquals(array3, array4));
        System.out.println(Arrays.deepEquals(array, array3));
        System.out.println(Arrays.deepEquals(array3, array5));
        System.out.println(Arrays.deepEquals(array4, array5));
    }
}
