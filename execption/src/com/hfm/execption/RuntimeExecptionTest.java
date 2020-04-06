package com.hfm.execption;

/**
 * @author hfm
 * @version 1.01 2020-03-28 18:07
 * @date 2020/3/28
 */
public class RuntimeExecptionTest {
    public static void main(String[] args) {
        System.out.println();
        int[] arr = {1, 2};
        arr = null;
        // print (1, 0, arr);
        print(1, 2, arr);
        System.out.println("over");
    }

    /**
     *
     * @param x
     * @param y
     * @param arr
     */
    public static void print(int x, int y, int[] arr) {
        try {
            System.out.println(arr[1]);
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("算术异常。。。");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("数组角标越界。。。");
        } catch (NullPointerException e) {
            e.toString();
            e.getMessage();
            e.printStackTrace();
            System.out.println("空指针异常。。。");
        }
        System.out.println("函数执行完毕");
    }
}
