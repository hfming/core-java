package com.hfming.operators;

/**
 * 三元运算符
 * 
 * @version 1.01 2019-09-17
 * @author hfm
 */
public class TernaryOperator {
    public static void main(String[] args) {
        // 获取两个数中大数。
        int x = 1;
        int y = 2;
        int z;
        z = x > y ? x : y;
        // 2
        System.out.println(z); 
        // 判断一个数是奇数还是偶数
        int x1 = 5;
        System.out.println((x1 % 2 == 0 ? "偶数" : "奇数"));
        int age = 16;
        System.out.println(age >= 18 ? "成年人" : "未成年人");
        int status = 0;
        System.out.println(status == 0 ? "未缴费" : "已缴费");
    }
}
