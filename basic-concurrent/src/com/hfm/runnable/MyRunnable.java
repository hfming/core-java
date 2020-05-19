package com.hfm.runnable;
/**
 * 1. 实现 RUnnable 接口
 */

/**
 * 通过实现Runnable 接口创建自定义线程类
 *
 * @author hfm
 * @version 1.01
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    /**
     * 2.重写 run 方法，把自定义线程的任务代码定义在run方法上。
     */
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("1");
        MyRunnable myRunnable2 = new MyRunnable("2");
        Thread thread1 = new Thread(myRunnable1, "1");
        Thread thread2 = new Thread(myRunnable2, "2");
        thread1.start();
        thread2.start();
    }
}
