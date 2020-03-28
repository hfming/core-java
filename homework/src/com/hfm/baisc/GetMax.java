package com.hfm.baisc;

/**
 * 练习 请编写1个程序 求出1个整型数组中的最大值和次大值。
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class GetMax {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4345, 56, 56, 43, 454};
        int max = 0;
        int nex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);
        for (int i = 0; i < arr.length; i++) {
            if (nex < arr[i] && max > arr[i]) {
                nex = arr[i];
            }
        }
        System.out.println("次大值为：" + nex);
    }
}
