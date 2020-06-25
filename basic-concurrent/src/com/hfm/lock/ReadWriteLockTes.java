package com.hfm.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description ReadWriteLock 读写锁
 * 写写/读写互斥
 * @date 2020-06-15 14:38
 */
public class ReadWriteLockTes {
    private int num = 0;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void get() {
        readWriteLock.readLock().lock();
        try {
            System.out.println("读：" + num);
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void set(int num) {
        readWriteLock.writeLock().lock();
        try {
            this.num = num;
            System.out.println("写：" + num);
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockTes readWriteLockTes = new ReadWriteLockTes();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockTes.set((int) (Math.random()*100));
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockTes.get();
                }
            }).start();
        }
    }
}
