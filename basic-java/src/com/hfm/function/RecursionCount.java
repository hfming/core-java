package com.hfm.function;

/**
 * 练习：计算运行次数
 *
 * @author hfm
 * @version 1.01 2020-04-03 14:46
 * @date 2020/4/3
 */
public class RecursionCount {
    private static int count;

    public static void main(String[] args) {
        // 287
        recursion(10);
    }

    /**
     * 递归
     *
     * @param k
     * @return
     */
    public static int recursion(int k) {
        count++;
        System.out.println("count:" + count + " k:" + k);
        if (k <= 0) {
            return 0;
        }
        return recursion(k - 1) + recursion(k - 2);
    }
}
