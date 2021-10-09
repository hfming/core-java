package com.hfm.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-15 13:58
 */
public class ConditionWay {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int num = 1;

    public void loopA() {
        lock.lock();
        try {
            if (num != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("A" + ":" + i);
            }
            num = 2;
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            if (num != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + ":" + i);
            }
            num = 3;
            condition3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            if (num != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("C" + ":" + i);
            }
            System.out.println("==============");
            num = 1;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionWay alternateTest3 = new ConditionWay();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                alternateTest3.loopA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                alternateTest3.loopB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                alternateTest3.loopC();
            }

        }).start();
    }
}

