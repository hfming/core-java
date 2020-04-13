package com.hfm.execption;

/**
 * @author hfm
 * @version 1.01 2020-04-07 22:07
 * @date 2020/4/7
 */
public class NullPointerExceptionTest {
    int i = 1;

    public static void main(String[] args) {
        NullPointerExceptionTest t = new NullPointerExceptionTest();
        t = null;
        System.out.println(t.i);
    }
}
