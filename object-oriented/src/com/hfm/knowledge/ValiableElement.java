package com.hfm.knowledge;

/**
 * 可变参数
 *
 * @author hfm
 * @version 1.01 2020-03-27 19:52
 * @date 2020/3/27
 */
public class ValiableElement {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        System.out.println(add(a, b, c, d));
    }

    /**
     * 可变参数
     *
     * @param a
     * @param b
     * @param arr
     */
    public static int add(int a, int b, int... arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
