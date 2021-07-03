package com.hfm.execption;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-03 14:20
 * @Description 在抛出异常之前，会先执行 Finally 中的语句
 * @date 2021/6/3
 */
public class RunTimeExceptionDemo {
    public static void main(String[] args) {
        // 进入方法A
        // 方法A的 Finally 块
        // 抛出异常
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 进入方法B
        // 方法B的 Finally 块
        methodB();
    }

    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("抛出异常");
        } finally {
            System.out.println("方法A的 Finally 块");
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("方法B的 Finally 块");
        }
    }
}
