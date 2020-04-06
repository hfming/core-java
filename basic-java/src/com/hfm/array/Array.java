package com.hfm.array;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 数组 Demo
 *
 * @author hfm
 * @version 1.02 2019-09-19
 */
public class Array implements Serializable {

    private static final long serialVersionUID = 2590380227656483356L;

    public static void main(String[] args) {

        // 数组定义
        // 方式一：数据类型[] 变量名 = new 数据类型[容量大小];
        int[] arr1 = new int[10];

        // 方式二：元素类型[] 数组名 = new 元素类型[]{元素，元素，……};
        int[] arr2 = new int[]{10, 23, 42, 1, 1, 1, 11};

        // 多个数组同时定义
        int[] arr21 = new int[]{232, 454, 54532}, arr31 = new int[]{121, 3232, 323, 32};

        int[] arr41 = new int[10], arr51 = new int[20];

        System.out.println(Arrays.toString(arr21));
        System.out.println(Arrays.toString(arr31));

        // 数组初始化赋值
        // 方式一：数组元素每一个都进行赋值
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // 方式二：不使用运算符 new
        int[] arr3 = new int[]{10, 23, 42, 1, 1, 1, 11};

        // 数组遍历
        // 方式一：for循环
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        // 方式二：for_each 循环 错误
        for (int j : arr3) {
            System.out.print(j + "	");
        }

        // 数组常见异常
        // java.lang.ArrayIndexOutOfBoundsException
        int[] x = {1, 2, 3};
        // System.out.println(x[3]);

        // java.lang.NullPointerException
        int[] x1 = {1, 2, 3};
        x1 = null;
        // System.out.println(x1[1]);

        // 一个数组取出最大值
        int max = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (max < arr3[i]) {
                max = arr3[i];
            }
        }
        System.out.println(max);
        // Arrays.toString(arg1);
    }
}
