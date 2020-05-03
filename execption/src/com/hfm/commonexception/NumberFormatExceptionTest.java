package com.hfm.commonexception;

/**
 * @author hfm
 * @version 1.01 2020-04-16 1:53
 * @date 2020/4/16
 */
public class NumberFormatExceptionTest {
    public static void main(String[] args) {
        String str = "abc";
        int i = Integer.parseInt(str);
    }
}
