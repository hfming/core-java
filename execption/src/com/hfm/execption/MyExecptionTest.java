package com.hfm.execption;

/**
 * @author hfm
 * @version 1.01 2020-03-28 17:48
 * @date 2020/3/28
 */
public class MyExecptionTest {
    public static void main(String[] args) {
        NoMoneyException noMoneyException = new NoMoneyException("I have no money!");
        System.out.println(noMoneyException.getMessage());
    }
}
