package com.hfm.execption;

import java.util.Date;

/**
 * @author hfm
 * @version 1.01 2020-04-07 22:11
 * @date 2020/4/7
 */
public class ClassCastExceptionTest {
    public static void main(String[] args) {
        Object obj = new Date();
        ClassCastExceptionTest order;
        order = (ClassCastExceptionTest) obj;
        System.out.println(order);
    }
}
