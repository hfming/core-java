package com.hfm.function;

/**
 * 函数重载
 *
 * @author hfm
 * @version 1.01 2019-09-19
 */
public class FunctionOverloading {
    public static void main(String[] args) {
        int sum = 0;
        sum = add(1, 495, 67);
        System.out.println(sum);
        System.out.println("helloworld");

        //定义不同数据类型的变量
        byte a = 10;
        byte b = 20;
        short c = 10;
        short d = 20;
        int e = 10;
        int f = 10;
        long g = 10;
        long h = 20;
        // 调用
        System.out.println(compare(a, b));
        System.out.println(compare(c, d));
        System.out.println(compare(e, f));
        System.out.println(compare(g, h));
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


    /**
     * 两个byte类型的
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(byte a, byte b) {
        System.out.println("byte");
        return a == b;
    }

    /**
     * 两个short类型的
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(short a, short b) {
        System.out.println("short");
        return a == b;
    }

    /**
     * 两个int类型的
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(int a, int b) {
        System.out.println("int");
        return a == b;
    }

    /**
     * 两个long类型的
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(long a, long b) {
        System.out.println("long");
        return a == b;
    }

    /**
     * @param a
     */
    public static void println(byte a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(short a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(int a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(long a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(float a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(double a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(char a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(boolean a) {
        System.out.println(a);
    }

    /**
     * @param a
     */
    public static void println(String a) {
        System.out.println(a);
    }
}
