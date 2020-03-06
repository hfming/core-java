package com.hfming.array;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * Arrays.parallelSetAll( )方法
 * 
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysSetAllTest {
    public static void main(String[] args) {
        int[] arr3 = new int[5];

        Arrays.setAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                // operand代表正在计算的元素的索引
                return operand + 5;
            }
        });
        System.out.println(Arrays.toString(arr3));

        // lambda表达式改造
        Arrays.setAll(arr3, (int op) -> {
            return op + 5;
        });
        System.out.println(Arrays.toString(arr3));

        Arrays.setAll(arr3, op -> op + 5);
        System.out.println(Arrays.toString(arr3));

        // Arrays.parallelSetAll( )方法
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                // operand代表正在计算的元素的索引
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));

        // lambda表达式改造
        Arrays.parallelSetAll(arr3, (int op) -> {
            return op + 5;
        });
        System.out.println(Arrays.toString(arr3));
    }
}
