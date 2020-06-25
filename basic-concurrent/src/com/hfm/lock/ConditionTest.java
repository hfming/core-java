package com.hfm.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-15 11:40
 */
public class ConditionTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        // 每次调用返回一个全新的 Condition 对象
        System.out.println(lock.newCondition());
        System.out.println(lock.newCondition());

        System.out.println(lock.newCondition() == lock.newCondition());
    }
}
