package com.hfm.valuepass;

/**
 * 基本数据类型值交换
 *
 * @author hfm
 * @version 1.01 2020-03-27 16:10
 * @date 2020/3/27
 */
public class BasicDateTypeExchangeValue {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        // 交换失败，仅仅是形参进行交换，操纵的是基本数据类型的复制品
        exchangeBasisValue(a, b);
        System.out.println("a" + a + " b" + b);

        // 中间值法交换
        int temp = a;
        temp = a;
        a = b;
        b = temp;
        // 没有使用形参交换，交换成功
        System.out.println("a" + a + " b" + b);

        // 加减法交换交换基本数据类型的值
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a" + a + " b" + b);

        // 异或法交换基本数据类型的值
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a" + a + " b" + b);

        a = 1;
        b = 2;
        System.out.println("a" + a + " b" + b);
        // 交换失败，传入基本数据类型复制品
        change(a, b);
        System.out.println("a" + a + " b" + b);
    }

    /**
     * 基本数据类型进行交换，交换失败，交换的只是形参中的数值
     *
     * @param num1
     * @param num2
     */
    public static void exchangeBasisValue(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }

    /**
     * 赋值操作
     * @param arr
     */
    public static void assignment(int[] arr) {
        arr[0] = 200;
    }

    /**
     * 传入的是基本数据类型复制品，交换失败
     * @param a
     * @param b
     */
    public static void change(int a, int b) {
        a = b;
        b = a;
    }
}
