package com.hfm.baisc.java;

import java.util.Scanner;

/**
 * 练习:大家都知道，男大当婚，女大当嫁。那么女方家长要嫁女儿，当然要提出一定的条件：高：180cm以上；富：财富1千万以上；帅：是。如果这三个条件同时满足，则：“我一定要嫁给他!!!”如果三个条件有为真的情况，则：“嫁吧，比上不足，比下有余。”如果三个条件都不满足，则：“不嫁！
 *
 * @author hfm
 * @version 1.01 2020-03-19 15:08
 * @date 2020/3/19
 */
public class JudgeMarry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入身高");
        double heigth = scanner.nextDouble();
        System.out.println("输入财富值");
        double money = scanner.nextDouble();
        System.out.println("输入帅气值");
        double shuai = scanner.nextDouble();
        if (heigth > 180 && money > 1000_0000.0 && shuai > 60.0) {
            System.out.println("我一定要嫁给他!!!");
        } else if (heigth > 180 || money > 1000_0000.0 || shuai > 60.0) {
            System.out.println("嫁吧，比上不足，比下有余。");
        } else {
            System.out.println("不嫁");
        }
    }
}
