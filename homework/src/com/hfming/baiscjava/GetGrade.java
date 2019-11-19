package com.hfming.baiscjava;

import java.util.Scanner;

/**
 * 练习 .给定一个百分制的分数，输出相应的等级。
 * 90分以上     A级
 * 80~89        B级
 * 70~79        C级
 * 60~69        D级
 * 60分以下     E级
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class GetGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩");
        double grade = scanner.nextDouble();
        if (grade < 60 && grade >= 0) {
            System.out.println("成绩为E");
        }
        if (grade >= 60 && grade < 70) {
            System.out.println("成绩为D");
        }
        if (grade >= 70 && grade < 80) {
            System.out.println("成绩为C");
        }
        if (grade >= 80 && grade < 90) {
            System.out.println("成绩为B");
        }
        if (grade >= 90 && grade <= 100) {
            System.out.println("成绩为A");
        }
        if (grade < 0 || grade > 100) {
            System.out.println("输入错误");
        }
    }
}
