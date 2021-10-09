package com.hfm.sequentialcontrol;

import org.junit.jupiter.api.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-15 12:28
 * @Description
 * @date 2021/9/15
 */
public class JoinWay {
    /**
     * 两条线程
     */
    @Test
    public void towThread() {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "线程A");

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B");

        thread1.start();
        thread2.start();
    }

    /**
     * 三条线程
     */
    @Test
    public void threeThread() {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "线程A");

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B");

        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程C");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 通用方法
     */
    @Test
    public void universalWay(){
        MyThread myThread1 = new MyThread(null,"线程A");
        MyThread myThread2 = new MyThread(myThread1,"线程B");
        MyThread myThread3 = new MyThread(myThread2,"线程C");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    static class MyThread extends Thread{
        /**
         * 前一个要执行的线程
         */
        private MyThread preThread;

        /**
         * 构造函数
         * @param preThread
         * @param name
         */
        public MyThread(MyThread preThread,String name) {
            this.preThread = preThread;
            super.setName(name);
        }

        @Override
        public void run() {
            if (preThread != null) {
                try {
                    preThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 线程要执行的方法
            System.out.println(Thread.currentThread().getName());
        }
    }
}
