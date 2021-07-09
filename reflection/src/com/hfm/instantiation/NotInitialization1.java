package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 10:48
 * @Description
 * @date 2021/7/7
 */
public class NotInitialization1 {
    public static void main(String[] args) {
        // hello world 1
        // 静态代码块不执行，只执行静态常量初始化步骤
        System.out.println(StaticConst1.HELLOWORLD);
    }
}
