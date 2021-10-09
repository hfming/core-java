package com.hfm.monitor;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-13 21:08
 * @Description
 * @date 2021/9/13
 */
public class MonitorTest {
    static int count;
    static final Object o = new Object();

    public static void main(String[] args) {
        synchronized (o) {
            count++;
        }
    }
}
