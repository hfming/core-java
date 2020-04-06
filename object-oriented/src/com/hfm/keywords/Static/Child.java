package com.hfm.keywords.Static;

/**
 * @author hfm
 * @version 1.01 2020-04-03 21:18
 * @date 2020/4/3
 */
public class Child extends Father {
    public static void print() {
        System.out.println("子类静态方法");
    }

    @Override
    public void print1() {
        System.out.println("子类静态方法");
    }
}
