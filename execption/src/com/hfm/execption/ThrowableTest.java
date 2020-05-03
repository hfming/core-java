package com.hfm.execption;

import java.io.IOException;

/**
 * 异常基类 Throwable
 *
 * @author hfm
 * @version 1.01 2020-03-28 12:22
 * @date 2020/3/28
 */
public class ThrowableTest {
    public static void main(String[] args) {
        // 构造函数
        Throwable throwable = new Throwable();
        System.out.println(throwable.toString());

        Throwable throwable2 = new Throwable("This is a new throwable!");
        System.out.println(throwable2.toString());

        Throwable throwable3 = new Throwable("This is a new throwable!",throwable2);
        System.out.println(throwable3.toString());

        Throwable throwable4 = new Throwable(throwable2);
        System.out.println(throwable4.toString());

        // new Throwable("This is a new throwable!",throwable4,true,true); 为 protect 构造方法只能同包使用
        // Throwable throwable5 = new Throwable("This is a new throwable!",throwable4,true,true);
        //System.out.println(throwable5.toString());

        // 常用方法
        // 将指定的异常附加到为了传递此异常而被抑制的异常。
        throwable4.addSuppressed(new IOException("IO 异常"));

        System.out.println(throwable4.fillInStackTrace());

        System.out.println(throwable4.getCause());

        // 返回此throwable的详细消息字符串。
        throwable.getMessage();

        // 提供对printStackTrace()打印的堆栈跟踪信息的编程访问。
        throwable.getStackTrace();

        // 将这个throwable及其回溯打印到标准错误流。
        throwable4.printStackTrace();

        // 返回此throwable的简短描述。
        throwable.toString();
    }
}
