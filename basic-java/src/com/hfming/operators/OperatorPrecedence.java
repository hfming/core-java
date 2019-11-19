package com.hfming.operators;

/**
 * 操作符优先级练习
 * 
 * @version 1.01 2019-09-17
 * @author hfm
 */
public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = 1 + a / b * 3 + c / (a * b / c + 1);
        System.out.println("结果：" + result); // 4
        /*
         * 1+a/b*3 +c/(a*b/c+1); (a*b/c+1) = 1*2/3+1 = 1 1+a/b*3 +c/1 = 1+ 0 + 3/1 = 4
         */
    }
}
