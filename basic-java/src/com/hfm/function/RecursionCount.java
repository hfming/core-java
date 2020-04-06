package com.hfm.function;

/**
 * @author hfm
 * @version 1.01 2020-04-03 14:46
 * @date 2020/4/3
 */
public class RecursionCount {
    public static void main(String[] args) {
        recursion(10);
    }

    private static int count;

    public static int recursion(int k) {
        count++;
        System.out.println("count:" + count + " k:" + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k - 1) + recursion(k - 2);
    }
}
