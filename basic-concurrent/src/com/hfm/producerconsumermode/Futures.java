package com.hfm.producerconsumermode;

import java.util.LinkedList;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 18:50
 * @Description
 * @date 2021/9/14
 */
public class Futures {
    /**
     * 用于存储生产者生产的产品
     */
    private static volatile LinkedList<Product> products = new LinkedList<>();
    /**
     * 队列长度
     */
    private int capacity;

    public Futures(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 生产者生产产品，并将生产出的产品添加到产品队列中
     *
     * @param product
     */
    public void put(Product product) {
        synchronized (products) {
            // 产品队列是否已经满了
            while (products.size() >= capacity) {
                // 产品队列已经满了，生产线程无限等待
                try {
                    System.out.println("产品队列已满，"+Thread.currentThread().getName()+"停止生产");
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.addLast(product);
            // 已经生产出产品了，通知消费者进行消费
            products.notifyAll();
        }
    }

    /**
     * 消费者进行消费
     *
     * @return
     */
    public Product get() {
        synchronized (products) {
            while (products.isEmpty()) {
                // 没有产品
                try {
                    System.out.println("没有产品，"+Thread.currentThread().getName()+"停止消费");
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 产品队列中有产品消费者可以获取产品
            return products.removeFirst();
        }
    }
}
