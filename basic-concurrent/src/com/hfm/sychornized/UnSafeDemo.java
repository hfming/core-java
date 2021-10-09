package com.hfm.sychornized;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-12 22:28
 * @Description
 * @date 2021/9/12
 */
public class UnSafeDemo {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--;
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
