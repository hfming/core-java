package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 12:08
 * @Description
 * @date 2021/7/7
 */
public class Son extends Father{
    static int b = getNum();
    static {
        System.out.println("3");
    }

    private static int getNum() {
        System.out.println("4");
        return 20;
    }

    public static void main(String[] args) {
        // 2
        // 1
        // 4
        // 3
    }
}