package com.hfm.commonexception;

/**
 * @author hfm
 * @version 1.01 2020-04-16 1:48
 * @date 2020/4/16
 */
public class StringIndexOutOfBoundsExecptionTest {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0,5));
    }
}
