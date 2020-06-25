package com.hfm.juc;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 21:27
 */
public class CASTest {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int cas(int expectVaule, int newValue) {
        int oldValue = value;

        // A == V 时,将 B 的值赋予 V
        if (oldValue == expectVaule) {
            this.value = newValue;
        }
        return oldValue;
    }

    /**
     * 设置
     *
     * @param expectedVaule
     * @param newVaule
     * @return
     */
    public synchronized boolean caset(int expectedVaule, int newVaule) {
        return expectedVaule == cas(expectedVaule, newVaule);
    }
}