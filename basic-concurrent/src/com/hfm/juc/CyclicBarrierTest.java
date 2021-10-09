package com.hfm.juc;

import java.util.concurrent.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-18 20:45
 * @Description
 * @date 2021/9/18
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        // 计数到达3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 9; i++) {
            int j = i;
            executorService.submit(() -> {
                try {
                    cyclicBarrier.await();
                    // 三秒后三条线程都计数减一，即三秒后所有等待的线程都开始执行
                    Thread.currentThread().setName("cyclicBarrier 线程" + j);
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
