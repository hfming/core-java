package com.hfming.baiscjava;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 练习 用户输入班级的人数,然后依次输入每个同学的成绩. 输入完毕之后,如果及格率没有达到60%， 就为每1个没有及格的成绩加2分,直到及格率达到60%为止。
 *
 * @author hfm
 * @version 1.01 2019.10.15
 */
public class InproveGread {
    public static void main(String[] args) {
        System.out.println("请输入班级人数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("输入的班级人数为：" + num);
        int[] arr = new int[num];
        System.out.println("请依次输入班级同学的成绩");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("正在计算平均分！");
        int sum;
        int average;
        OUT:
        for (; ; ) {
            sum = 0;
            average = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            //System.out.println(sum);
            average = sum / arr.length;
            System.out.println(average);
            if (average >= 60) {
                System.out.println(Arrays.toString(arr));
                break OUT;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] < 60) {
                        arr[i] += 2;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
