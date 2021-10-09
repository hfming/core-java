package com.hfm.monitor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-13 21:31
 * @Description
 * @date 2021/9/13
 */
public class LightweightLock {
    static final Object object = new Object();

    public static void method1() {
        // 同步代码块A
        synchronized (object) {
            method2();
        }
    }

    private static void method2() {
        // 同步代码块 2
        synchronized (object) {

        }
    }
}
