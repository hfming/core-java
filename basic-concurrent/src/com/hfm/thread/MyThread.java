package com.hfm.thread;
/**
 * 自定义线程类
 *
 * @author hfm
 */

/**
 * 1.创建一个自定义类，继承Thread 类
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    /**
     * 重写 run 方法，把自定义线程的任务代码定义在run方法上。
     */
    @Override
    public void run() {
        System.out.println("调用了自定义线程");
        System.out.println(this.getState());
    }

    public static void main(String[] args) {
        // 3. 创建自定义线程对象
        MyThread myThread = new MyThread("自定义线程类");
        // 4. 启动执行 自定义线程对象 start() 方法自动调用run 方法
        myThread.start();
        // start() 源码
        //    public synchronized void start() {
        //        if (this.threadStatus != 0) {
        //            throw new IllegalThreadStateException();
        //        } else {
        //            this.group.add(this);
        //            boolean started = false;
        //
        //            try {
        //                this.start0();
        //                started = true;
        //            } finally {
        //                try {
        //                    if (!started) {
        //                        this.group.threadStartFailed(this);
        //                    }
        //                } catch (Throwable var8) {
        //                }
        //
        //            }
        //
        //        }
        //    }
    }
}
