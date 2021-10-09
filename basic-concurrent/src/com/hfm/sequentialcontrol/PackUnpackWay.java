package com.hfm.sequentialcontrol;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 16:38
 * @Description
 * @date 2021/9/15
 */
public class PackUnpackWay {
    /**
     * 两条线程
     */
    @Test
    public void twoThread() {
        Thread thread1 = new Thread(() -> {
            // 停止
            LockSupport.park();
            // 运行
            System.out.println(Thread.currentThread().getName());
        }, "线程A");

        Thread thread2 = new Thread(() -> {
            // 运行
            System.out.println(Thread.currentThread().getName());
            // 运行 1
            LockSupport.unpark(thread1);
        }, "线程B");

        thread1.start();
        thread2.start();
    }

    /**
     * 三条线程
     */
    @Test
    public void twoThree() {
        Thread thread1 = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName());
        }, "线程A");

        Thread thread2 = new Thread(() -> {
            // 停止
            LockSupport.park();
            // 运行
            System.out.println(Thread.currentThread().getName());
            // 运行 1
            LockSupport.unpark(thread1);
        }, "线程B");

        Thread thread3 = new Thread(() -> {
            // 运行
            System.out.println(Thread.currentThread().getName());
            // 运行 2
            LockSupport.unpark(thread2);
        }, "线程C");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 通用方法
     */
    @Test
    public void universalWay() {
        MyThread thread1 = new MyThread("线程A", null, true);
        MyThread thread2 = new MyThread("线程B", thread1, true);
        MyThread thread3 = new MyThread("线程C", thread2, false);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyThread extends Thread {
        /**
         * 下一个线程
         */
        private MyThread nextThread;
        /**
         * 是否需要停止自身线程
         */
        private boolean flag;

        /**
         * 构造函数
         *
         * @param name
         * @param nextThread
         * @param flag
         */
        public MyThread(String name, MyThread nextThread, boolean flag) {
            this.nextThread = nextThread;
            super.setName(name);
            this.flag = flag;
        }

        @Override
        public void run() {
            // 判断是否停止当前线程
            if (flag) {
                LockSupport.park();
            }
            // 运行当前线程
            System.out.println(Thread.currentThread().getName());
            // 判断是否有下一个线程，如果有运行
            if (nextThread != null) {
                LockSupport.unpark(nextThread);
            }
        }
    }
}
