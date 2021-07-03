package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 线程安全问题
 * @date 2020-05-06 16:22
 */
public class UnsafetySaleTikects implements Runnable {
    /**
     * 类共享数据
     */
    private  int num = 50;

    /**
     * 构造函数
     */
    public UnsafetySaleTikects() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "号票");
                num--;
            } else {
                System.out.println("售罄了...");
                break;
            }
        }
    }

    public static void main(String[] args) {
        UnsafetySaleTikects tikects = new UnsafetySaleTikects();
        new Thread(tikects, "1").start();
        new Thread(tikects, "2").start();
        new Thread(tikects, "3").start();
    }
}
