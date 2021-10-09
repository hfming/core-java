package com.hfm.producerconsumermode;

import java.util.concurrent.TimeUnit;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 19:07
 * @Description
 * @date 2021/9/14
 */
public class FuturesTest {
    public static void main(String[] args) {
        // 存储产品队列
        Futures futures = new Futures(10);

        // 西瓜汁生产者
        new Thread(() -> {
            // 每2秒生产一瓶西瓜汁
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "生产产品");
                    // 将生产出的产品加入到产品队列中
                    futures.put( new Product("西瓜汁",4));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "西瓜汁生产者").start();
        // 苹果汁生产者
        new Thread(() -> {
            // 每3秒生产一瓶苹果汁
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "生产产品");
                    // 将生产出的产品加入到产品队列中
                    futures.put( new Product("苹果汁",5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "苹果汁生产者").start();

        // 消费者
        new Thread(() -> {
            // 每一秒消费一个产品
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    // 获取到产品
                    Product product = futures.get();
                    System.out.println(Thread.currentThread().getName() + "消费"+product.getName()+"\t 价格"+product.getPrice());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();
    }
}
