package com.hfm.sychornized;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-13 16:47
 * @Description
 * @date 2021/9/13
 */
public class SafeDemo {
    static int counter = 0;
    /**
     * 多线程共享锁对象
     */
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // 同步代码块
                synchronized (object){
                    counter++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // 同步代码块
                synchronized (object){
                    counter--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        // 线程插入
        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
