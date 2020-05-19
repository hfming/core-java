package com.hfm.genericity;

import java.util.ArrayList;

/**
 * 自定义泛型类
 *
 * @param <T>
 * @author hfm
 */
public class MyArraysList<T> {
    /**
     * 泛型方法
     *
     * @param arr
     */
    public void reverse(T[] arr) {
        for (int startIndex = 0, endIndex = arr.length - 1; startIndex < endIndex; startIndex++, endIndex--) {
            T temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
        }
    }

    /**
     * 自定义泛型方法
     *
     * @param arr
     * @return
     */
    public String toString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sb.append("[" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                sb.append(arr[i] + "]");
            } else {
                sb.append(arr[i] + ",");
            }
        }
        return sb.toString();
    }

    public void printList(ArrayList<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public  MyArraysList<T> outGrnericity() {
        return this;
    }

    public static <T> void printList() {

    }

    public static void print() {

    }

}
