package com.hfm.sequentialcontrol;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 16:59
 * @Description
 * @date 2021/9/15
 */
public class AwaitSignalWay {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int i = 1;

    /**
     * 两条线程
     */
    @Test
    public void twoThread() {
        new Thread(() -> {
            lock.lock();
            try {
                while (i != 2) {
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程A").start();

        new Thread(() -> {
            lock.lock();
            try {
                while (i != 1) {
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程B").start();
    }

    /**
     * 三条线程
     */
    @Test
    public void twoThree() {
        new Thread(() -> {
            lock.lock();
            try {
                while (i != 3) {
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程A").start();

        new Thread(() -> {
            lock.lock();
            try {
                while (i != 2) {
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程B").start();

        new Thread(() -> {
            lock.lock();
            try {
                while (i != 1) {
                    condition.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程C").start();
    }

    /**
     * 通用方法
     */
    @Test
    public void universalWay() {
        new MyThread("线程A",3).start();
        new MyThread("线程B",2).start();
        new MyThread("线程C",1).start();

    }

    static class MyThread extends Thread {
        private static final ReentrantLock LOCK = new ReentrantLock();
        private static final Condition CONDITION = LOCK.newCondition();
        private static int i = 1;

        /**
         * 执行序号，线程私有
         */
        private int serialNumber;

        /**
         * 构造函数
         *
         * @param name
         * @param serialNumber
         */
        public MyThread(String name, int serialNumber) {
            this.serialNumber = serialNumber;
            super.setName(name);
        }

        @Override
        public void run() {
            LOCK.lock();
            try {
                while (i != serialNumber) {
                    CONDITION.await();
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                CONDITION.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }
}
