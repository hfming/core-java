package com.hfm.alternate;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 16:38
 * @Description
 * @date 2021/9/15
 */
public class PackUnpackWay {
    static Thread thread1;
    static Thread thread2;
    static Thread thread3;
    static final int FIVWTIME = 5;

    /**
     * 两条线程
     */
    @Test
    public void twoThread() {
        thread1 = new Thread(() -> {
            for (int i = 0; i < FIVWTIME; i++) {
                // 停止
                LockSupport.park();
                // 运行
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(thread2);
            }
        }, "线程A");

        thread2 = new Thread(() -> {
            for (int i = 0; i < FIVWTIME; i++) {
                LockSupport.park();
                // 运行
                System.out.println(Thread.currentThread().getName());
                // 运行 1
                LockSupport.unpark(thread1);
            }
        }, "线程B");

        thread1.start();
        thread2.start();

        LockSupport.unpark(thread2);
    }

    /**
     * 三条线程
     */
    @Test
    public void twoThree() {
        thread1 = new Thread(() -> {
            for (int i = 0; i < FIVWTIME; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(thread3);
            }
        }, "线程A");

        thread2 = new Thread(() -> {
            for (int i = 0; i < FIVWTIME; i++) {
                // 停止
                LockSupport.park();
                // 运行
                System.out.println(Thread.currentThread().getName());
                // 运行 1
                LockSupport.unpark(thread1);
            }
        }, "线程B");

        thread3 = new Thread(() -> {
            for (int i = 0; i < FIVWTIME; i++) {
                LockSupport.park();
                // 运行
                System.out.println(Thread.currentThread().getName());
                // 运行 2
                LockSupport.unpark(thread2);
            }
        }, "线程C");

        thread1.start();
        thread2.start();
        thread3.start();

        LockSupport.unpark(thread3);
    }

    static Thread thread11;
    static Thread thread22;
    static Thread thread33;

    /**
     * 通用方法
     */
    @Test
    public void universalWay() {
        Pack pack = new Pack();

        thread11 = new Thread(() -> {
            pack.run("线程A", thread33);
        });
        thread22 = new Thread(() -> {
            pack.run("线程B", thread11);
        });
        thread33 = new Thread(() -> {
            pack.run("线程C", thread22);
        });

        thread11.start();
        thread22.start();
        thread33.start();

        LockSupport.unpark(thread33);
    }

    static class Pack {
        /**
         * 下一个线程
         */
        private Thread nextThread;
        /**
         * 是否需要停止自身线程
         */

        private static final int FIVWTIME = 5;

        public void run(String name, Thread nextThread) {
            this.nextThread = nextThread;
            Thread.currentThread().setName(name);
            for (int i = 0; i < FIVWTIME; i++) {
                LockSupport.park();
                // 运行
                System.out.println(Thread.currentThread().getName());
                // 运行 2
                LockSupport.unpark(nextThread);
            }
        }
    }
}
