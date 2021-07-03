package com.hfm.function;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-05-29 19:03
 * @Description
 * @date 2021/5/29
 */
public class RecursionTest2 {
    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(product(100));
        System.out.println(fun(10));
        System.out.println(fibonacci(50));
    }

    /**
     * 递归计算和
     *
     * @param num
     * @return
     */
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }

    /**
     * 递归计算乘积
     *
     * @param num
     * @return
     */
    public static double product(double num) {
        if (num == 1) {
            return 1;
        }
        return num * product(num - 1);
    }

    /**
     * fun(0) = 1;
     * fun(1) = 4
     * fun(n+2) = 2*fun(n+1) + fun(n)
     *
     * @param num
     * @return
     */
    public static double fun(double num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 4;
        }
        return fun(num - 1) * 2 + fun(num - 2);
    }

    /**
     * 斐波那契数列
     *
     * @param num
     * @return
     */
    public static double fibonacci(double num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
