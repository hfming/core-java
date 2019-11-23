package com.hfming.baiscjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 练习 现在有如下的一个数组：int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ，要求清除数组中为0的元素，然后存储非零的数据存储到一个新数组中。
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class RemoveZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组，数值之间用“，”号隔开");
        String arrString = scanner.next();
        // 切割字符串
        String[] arr = arrString.split(",");
        int[] finalArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            finalArr[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(ArrayRemoveZero.arrayRemoveZreo(finalArr)));
    }
}
