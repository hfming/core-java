package com.hfm.state;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 22:35
 */
public class WatingStateTest {
    public static Object obj = new Object();

    public static void main(String[] args) {
        // 演示waiting
        new Thread(() -> {
            while (true) {
                synchronized (obj) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "=== 获取到锁对象，调用wait方法，进入waiting状态，释放锁对象");
                        // 无限等待,将锁释放了
                        obj.wait();
                        //obj.wait(5000); //计时等待, 5秒 时间到，自动醒来
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=== 从waiting状态醒来，获取到锁对象，继续执行了");
                }
            }
        }, "等待线程").start();
        new Thread(() -> {
            // 每隔3秒 唤醒一次
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 等待3秒钟");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 获取到锁对象,调用notify方法，释放锁对象");
                    obj.notify();
                }
            }
        }, "唤醒线程").start();
    }
}
