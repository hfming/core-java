package com.hfm.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description ReadWriteLock 读写锁
 * 写写/读写互斥
 * @date 2020-06-15 14:38
 */
public class ReadWriteLockTest {
    /**
     * Lock 锁要与 vloatil 一起使用
     */
    private volatile int num = 1111;
    /**
     * 读写锁
     */
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    /**
     * 加读锁
     */
    public void get() {
        readLock.lock();
        try {
            System.out.println("读：" + num);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 加写锁
     *
     * @param num
     */
    public void set(int num) {
        writeLock.lock();
        try {
            this.num = num;
            System.out.println("写：" + num);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTes = new ReadWriteLockTest();
        for (int i = 0; i < 100; i++) {
//            new Thread(() -> readWriteLockTes.get()).start();
            new Thread(() -> readWriteLockTes.set((int) (Math.random() * 100))).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> readWriteLockTes.get()).start();
        }
    }
}
