package com.hfming.baiscjava;

import java.util.Arrays;
import java.util.Scanner;
import cn.hfming.array.*;

/**
 * 练习 清除重复元素。 int[]   arr =  {1,4，9,4,1,1,7}；
 *
 * @author hfm
 * @version 1.01 2019-10-15
 */
public class CleanRepeat {
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
        System.out.println(Arrays.toString(ArrayCleanRepeat.arrayCleanRepeat(finalArr)));
    }
}
