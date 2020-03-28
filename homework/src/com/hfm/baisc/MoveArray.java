package com.hfm.baisc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 练习:有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 *
 * @author hfm
 * @version 1.01 2020-03-19 19:49
 * @date 2020/3/19
 */
public class MoveArray {
    public static void main(String[] args) {
        int[] arr = new int[]{343, 45, 232, 678, 8, 8644};

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入移动的个数");
        int m = scanner.nextInt();
        int[] temps1 = new int[m];

        int count = 0;
        // 将后M个数存储到temps1
        for (int i = arr.length - m; i < arr.length; i++) {
            temps1[count] = arr[i];
            count++;
        }
        // 将前面的数存储到temps2
        count = 0;
        int[] temps2 = new int[arr.length - m];
        for (int i = 0; i < arr.length - m; i++) {
            temps2[count] = arr[i];
            count++;
        }

        count =0;
        for (int i = 0; i < arr.length; i++) {
            if (i < m) {
                arr[i] = temps1[i];
            }else{
                arr[i] = temps2[count];
                count ++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
