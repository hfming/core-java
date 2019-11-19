package com.hfming.function;

/**
 * 函数重载
 *
 * @author hfm
 * @version 1.01 2019-09-19
 */
public class FunctionOverloading {
    public static void test(String[] args) {
        int sum = 0;
        sum = add(1, 495, 67);
        System.out.println(sum);
        System.out.println("helloworld");


    }

    /**
     * sum函数
     *
     * @param a
     * @param b
     * @return
     */
    private static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    /**
     * 重载sum函数
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int add(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }

    /**
     * 重载sum函数
     *
     * @param arr
     * @return
     */
    private static int add(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
