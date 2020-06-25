package com.hfm.alternate;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description CountDownLatch 闭锁 允许一个或多个线程一直等待。
 * @date 2020-06-15 11:49
 */
public class AlternateTest1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        CountDownLatch countDownLatch3 = new CountDownLatch(1);
        for (int i = 0; i < 2; i++) {
            new Thread(new FutureTask(new MyTask("A", countDownLatch))).start();
        }
        countDownLatch.await();

        new Thread(new FutureTask(new MyTask("B", countDownLatch2))).start();
        countDownLatch2.await();

        new Thread(new FutureTask(new MyTask("C", countDownLatch3))).start();
    }
}

class MyTask implements Callable {
    private CountDownLatch countDownLatch;
    private String name;

    public MyTask(String name, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + ":" + i);
        }
        countDownLatch.countDown();
        return null;
    }
}