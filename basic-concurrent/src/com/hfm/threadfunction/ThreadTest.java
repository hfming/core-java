package com.hfm.threadfunction;

import com.hfm.createthread.MyThread;

/**
 * 线程常用方法
 *
 * @author hfm
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread("自定义线程");
        myThread.start();
        // 线程的常用方法
        Thread thread = new Thread("线程1");
        // New 创建
        System.out.println(thread.getState());
        // 获取线程名称
        System.out.println(thread.getName());
        // 设置线程的名称
        thread.setName("线程1新名称");
        // thread.wait(100);
        thread.interrupt();
        // 线程休眠，设置线程休眠时间
        Thread.sleep(1000);
        // 返回当前线程对象的优先级，默认线程的优先级是5
        System.out.println(thread.getPriority());
        // 设置线程优先级
        thread.setPriority(2);
        System.out.println(thread.getPriority());
    }
}
