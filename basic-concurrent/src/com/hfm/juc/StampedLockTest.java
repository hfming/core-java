package com.hfm.juc;

import java.util.concurrent.locks.StampedLock;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-18 17:48
 * @Description
 * @date 2021/9/18
 */
public class StampedLockTest {
    private int data;
    private final StampedLock lock = new StampedLock();

    public StampedLockTest(int data) {
        this.data = data;
    }

    /**
     * 读操作
     *
     * @param readTime
     * @return
     */
    public int read(int readTime) {
        // 乐观读，获取戳
        long stamp = lock.tryOptimisticRead();
        System.out.println(stamp);
        try {
            Thread.sleep(readTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 判断 戳的版本，相等直接返回，不相等加读锁
        if (lock.validate(stamp)) {
            return data;
        }
        // 锁升级 - 读锁
        try {
            stamp = lock.readLock();
            Thread.sleep(readTime);
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp);
        }
        return data;
    }

    /**
     * 写操作
     *
     * @param newData
     */
    public void write(int newData) {
        // 写的时候返回一个 戳
        long stamp = lock.writeLock();
        System.out.println(stamp);
        try {
            Thread.sleep(2);
            this.data = newData;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 需要戳进行解锁
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        StampedLockTest dataContainer = new StampedLockTest(1);
        new Thread(() -> {
            dataContainer.read(1);
        }, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            dataContainer.write(0);
        }, "t2").start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            dataContainer.read(0);
        }, "t2").start();
    }
}
