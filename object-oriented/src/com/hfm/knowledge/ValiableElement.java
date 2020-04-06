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

    public void test(String[] msg) {
        System.out.println("含字符串数组参数的test方法");
    }

    public void test1(String book) {
        System.out.println("****与可变形参方法构成重载的test1方法****");
    }

    public void test1(String... books) {
        System.out.println("****形参长度可变的test1方法****");
    }
}
