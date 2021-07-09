package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 12:08
 * @Description
 * @date 2021/7/7
 */
public class Father {
    static int a = getNum();

    static {
        System.out.println("1");
    }

    private static int getNum() {
        System.out.println(2);
        return 10;
    }
}
