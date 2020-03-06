package com.hfming.controlprocess;

/**
 * for-each循环实例
 *
 * @author hfm
 * @version 1.01 2019-09-19
 */
public class ForEach {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 0, 6, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
