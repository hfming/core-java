package com.hfm.alternate;

import org.junit.jupiter.api.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 16:09
 * @Description
 * @date 2021/9/15
 */
public class WaitNotifyWay {
    static final int FIVWTIME = 5;
    Object o = new Object();
    int i = 1;

    /**
     * 两条线程
     */
    @Test
    public void twoThread() {
        new Thread(() -> {
            for (int j = 0; j < FIVWTIME; j++) {
                synchronized (o) {
                    while (i != 2) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i = 1;
                    System.out.println(Thread.currentThread().getName());
                    o.notify();
                }
            }
        }, "线程A").start();

        new Thread(() -> {
            for (int j = 0; j < FIVWTIME; j++) {
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
            }
        }, "线程B").start();
    }

    /**
     * 三条线程
     */
    @Test
    public void twoThree() {
        new Thread(() -> {
            for (int j = 0; j < FIVWTIME; j++) {
                synchronized (o) {
                    while (i != 3) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i = 1;
                    System.out.println(Thread.currentThread().getName());
                    o.notifyAll();
                }
            }
        }, "线程A").start();

        new Thread(() -> {
            for (int j = 0; j < FIVWTIME; j++) {
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
            }
        }, "线程B").start();

        new Thread(() -> {
            for (int j = 0; j < FIVWTIME; j++) {
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
            }
        }, "线程C").start();
    }

    /**
     * 通用方法
     */
    @Test
    public void universalWay() {
        new MyThread("线程A", 3,3).start();
        new MyThread("线程B", 2,1).start();
        new MyThread("线程C", 1,2).start();
    }

    static class MyThread extends Thread {
        private static Object o = new Object();
        private static int i = 1;
        private static final int FIVWTIME = 5;

        /**
         * 执行序号，线程私有
         */
        private int serialNumber;
        /**
         * 下一个编号
         */
        private int nextNumber;
        /**
         * 构造函数
         *
         * @param name
         * @param serialNumber
         */
        public MyThread(String name, int serialNumber,int nextNumber) {
            this.serialNumber = serialNumber;
            super.setName(name);
            this.nextNumber = nextNumber;
        }

        @Override
        public void run() {
            for (int j = 0; j < FIVWTIME; j++) {
                synchronized (o) {
                    while (i != this.serialNumber) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i = nextNumber;
                    System.out.println(Thread.currentThread().getName());
                    o.notifyAll();
                }
            }
        }
    }
}
