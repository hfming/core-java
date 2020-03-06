package com.hfming.array;

import java.util.Arrays;

/**
 * Arrays.copyOf( ) 与 Arrays.copyOfRange( ) 方法测试
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class ArraysCopyOfTest {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 23, 45, 565};

        // 如果位数不够(目标长度不够)，会使用0进行补位
        int[] result = Arrays.copyOf(ints, 10);
        // 1    23    45    565    0    0    0    0    0    0
        for (int i : result) {
            System.out.print(i + "    ");
        }
        System.out.println();

        // 如果位数够，就取最小的数组
        result = Arrays.copyOf(ints, 2);
        // 1    23
        for (int i : result) {
            System.out.print(i + "    ");
        }
        System.out.println();

        // Arrays.copyOfRange() 方法
        result = Arrays.copyOfRange(ints, 2, 4);
        // 45    565
        for (int i : result) {
            System.out.print(i + "    ");
        }
    }
}
