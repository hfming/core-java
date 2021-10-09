package com.hfm.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 21:37
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "延时线程").start();

        new Thread(() -> {
            try {
                // 每一秒钟 countDown 一次，计数减一
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "countDown 线程").start();
    }

    /**
     * 与线程池一起使用
     */
    public void withExecutor() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            try {
                countDownLatch.await();
                Thread.currentThread().setName("延迟线程");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            int j = i;
            executorService.submit(() -> {
                try {
                    // 三秒后三条线程都计数减一，即三秒后所有等待的线程都开始执行
                    Thread.currentThread().setName("countDown 线程" + j);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}