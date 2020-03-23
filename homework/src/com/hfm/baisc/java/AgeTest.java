package com.hfm.baisc.java;

/**
 * if-else demo
 * @author hfm
 * @version 1.01 2020-03-18 23:18
 * @date 2020/3/18
 */
public class AgeTest {
    public static void main(String args[]) {
        int age = 75;
        if (age < 0) {
            System.out.println("不可能！");
        } else if (age > 250) {
            System.out.println("是个妖怪！");
        } else {
            System.out.println("人家芳龄 " + age + " ,马马乎乎啦！");
        }
    }
}
