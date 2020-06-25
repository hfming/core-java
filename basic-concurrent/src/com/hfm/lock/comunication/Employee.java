package com.hfm.lock.comunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-15 11:18
 */
public class Employee {
    private Lock lock = new ReentrantLock();
    private Condition condition = this.lock.newCondition();

    /**
     * 只有一件商品
     */
    private Product product = new Product();

    /**
     * 进货
     */
    public void buy() {
        int i = 0;
        while (true) {
            lock.lock();
            try {
                boolean flag = product.isFlag();
                System.out.println("生产者生产前" + flag);
                if (flag) {
                    System.out.println("无限等待");
                    condition.await();
                }
                if (i % 2 == 0) {
                    product.setName("摩托车");
                    product.setPrice(5000.00);
                } else {
                    product.setName("自行车");
                    product.setPrice(300.00);
                }
                i++;
                product.setFlag(true);
                System.out.println("生产者生产了" + product.getName() + ":" + product.getPrice());
                System.out.println("生产者生产后" + product.isFlag());
                // 唤醒消费者去消费
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 销售
     */
    public void sale() {
        while (true) {
            lock.lock();
            try {
                boolean flag = product.isFlag();
                System.out.println("消费者消费前" + flag);
                if (flag == false) {
                    System.out.println("无限等待");
                    condition.await();
                }
                System.out.println("消费者消费了：" + product.getName() + " 价格：" + product.getPrice());
                // 改标识
                product.setFlag(false);
                System.out.println("消费者消费后" + product.isFlag());
                // 如果产品已经被消费完毕,应该唤醒生产者去生成
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
