package com.hfm.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 21:37
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatch countDownLatch2 = new CountDownLatch(10);

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            new MyThread3(countDownLatch).start();
//        }
//        countDownLatch.await();
        long end = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            new MyThread4(countDownLatch2).start();
        }
        countDownLatch2.await();
        long end2 = System.currentTimeMillis();

//        System.out.println(end - start);
        System.out.println(end2 - end);
    }
}

class MyThread3 extends Thread{
    private CountDownLatch countDownLatch;

    public MyThread3(CountDownLatch countDownLatch) {
        this.countDownLatch =countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class MyThread4 extends Thread{
    private CountDownLatch countDownLatch;

    public MyThread4(CountDownLatch countDownLatch) {
        this.countDownLatch =countDownLatch;
    }

    @Override
    public void run() {
        synchronized (MyThread4.class) {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            countDownLatch.countDown();
        }
    }
}