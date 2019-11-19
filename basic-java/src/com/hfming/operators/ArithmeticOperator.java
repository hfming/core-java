package com.hfming.operators;

/**
 * 算数运算符
 * 
 * @version 1.1 2019-09-17
 * @author hfm
 */
public class ArithmeticOperator {
    public static void main(String[] args) {
        // + (正数，加法 、 连接符)
        // 加法
        System.out.println(1 + 2);
        // 正数
        System.out.println(+1);
        // 连接符
        System.out.println(1 + 2 + 3 + "A" + 1);

        // - (负号，减法)
        // 负号
        System.out.println(-1);
        // 减法
        System.out.println(2 - 1);

        // * 乘法
        System.out.println(3 * 4);

        // 除法
        System.out.println(5 / 4);

        // % %（取模，取余数）
        System.out.println(10 % 3);
        // 注意： 取模运算的结果正负是取决于被除数的正负。
        // 1
        System.out.println(10 % 3);
        // 1
        System.out.println(10 % -3);
        // -1
        System.out.println(-10 % 3);
        // -1
        System.out.println(-10 % -3);

        // ++ (自增): 自增就是操作数+1.
        // 前自增: ++位于操作数的前面。 先自增，后使用。
        // 后自增: ++位于操作数的后面。 先使用，后自增，
        int aInt = 0;
        // 前自增:先自增，后使用。i=i+1; result = i;
        int result1 = ++aInt;
        // result1=1
        System.out.println("result1=" + result1);
        // 后自增:先使用，后自增。 result = i; i=i+1
        int result2 = aInt++;
        // result1=1
        System.out.println("结果：" + result2 + " aInt=" + aInt);
        int num = 10;
        // int result = 10*10 . num = num+1;
        int result3 = 10 * num++;
        // 后自增:先使用，后自增。 restut=100
        System.out.println("结果：" + result3);
        int bInt = 0;
        // i2 =0
        bInt = bInt++;
        // 后自增:先使用，后自增。i2=0
        System.out.println(bInt);

        // --（自减）： 自减就是操作数-1.
        // 前自减： --位于操作数 的前面。 先自减，后使用。
        // 后自减: --位于操作数 的后面， 先使用，后自减
        int cInt = 1;
        // 前自减: 先自减，后使用。i = i-1; result = i;
        int result5 = --cInt;
        // 0
        System.out.println("result5 : " + result5);
        // 后自减:先使用，后自减， result = i ; i= i-1;
        int result6 = cInt--;
        // result6=0
        System.out.println("result : " + result6);
        int dInt = 10;
        int result7 = 10 * dInt--;
        // 后自减:先使用，后自减 result = 100
        System.out.println("result : " + result7);
    }
}
