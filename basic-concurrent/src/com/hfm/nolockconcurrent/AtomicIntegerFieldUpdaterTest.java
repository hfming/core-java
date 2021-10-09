package com.hfm.nolockconcurrent;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-16 22:24
 * @Description
 * @date 2021/9/16
 */
public class AtomicIntegerFieldUpdaterTest {
    private volatile int field;
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class, "field");

        AtomicIntegerFieldUpdaterTest test5 = new AtomicIntegerFieldUpdaterTest();
        fieldUpdater.compareAndSet(test5, 0, 10);

        // 修改成功 field = 10
        System.out.println(test5.field);

        // 修改成功 field = 20
        fieldUpdater.compareAndSet(test5, 10, 20);
        System.out.println(test5.field);

        // 修改失败 field = 20
        fieldUpdater.compareAndSet(test5, 10, 30);
        System.out.println(test5.field);
    }
}

