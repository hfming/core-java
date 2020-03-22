package com.hfm.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Arrays.parallelPrefix( )方法测试
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class ArraysParallelPrefixTest {
    public static void main(String[] args) {
        int[] arr2 = new int[]{1, 8, 51, 13, 46, 11, 22};

        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                // left代表数组中前一个索引处的元素，计算第一个元素时，left为1
                // right代表数组中当前索引处的元素
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));

        arr2 = new int[]{1, 8, 51, 13, 46, 11, 22};
        // lambda表达式方法
        Arrays.parallelPrefix(arr2, (int left, int right) -> {
            return left + right;
        });
        System.out.println(Arrays.toString(arr2));

        // 指定范围
        arr2 = new int[]{1, 8, 51, 13, 46, 11, 22};
        // lambda表达式方法
        Arrays.parallelPrefix(arr2, 1, 4, (int left, int right) -> {
            return left + right;
        });
        System.out.println(Arrays.toString(arr2));
    }
}
