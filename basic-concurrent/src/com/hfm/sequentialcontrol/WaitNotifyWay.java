package com.hfm.sequentialcontrol;

import org.junit.jupiter.api.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 16:09
 * @Description
 * @date 2021/9/15
 */
public class WaitNotifyWay {
    Object o = new Object();
    int i = 1;

    /**
     * 两条线程
     */
    @Test
    public void twoThread() {
        new Thread(() -> {
            synchronized (o) {
                while (i != 2) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notify();
            }
        }, "线程A").start();

        new Thread(() -> {
            synchronized (o) {
                while (i != 1) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notify();
            }
        }, "线程B").start();
    }

    /**
     * 三条线程
     */
    @Test
    public void twoThree() {
        new Thread(() -> {
            synchronized (o) {
                while (i != 3) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notifyAll();
            }
        }, "线程A").start();

        new Thread(() -> {
            synchronized (o) {
                while (i != 2) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notifyAll();
            }
        }, "线程B").start();

        new Thread(() -> {
            synchronized (o) {
                while (i != 1) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notifyAll();
            }
        }, "线程C").start();
    }

    /**
     * 通用方法
     */
    @Test
    public void universalWay() {
        new MyThread("线程A", 1).start();
        new MyThread("线程B", 2).start();
        new MyThread("线程C", 3).start();
    }

    static class MyThread extends Thread {
        private static Object o = new Object();
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
            synchronized (o) {
                while (i != this.serialNumber) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                System.out.println(Thread.currentThread().getName());
                o.notifyAll();
            }
        }
    }
}
