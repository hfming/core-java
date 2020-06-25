package com.hfm.comunication;

/**
 * 消费者类
 *
 * @author hfm
 */
public class Customer extends Thread {
    private Product product = null;

    public Customer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.product) {
                boolean flag = this.product.isFlag();
                if (flag) {
                    System.out.println("消费者消费了：" + product.getName() + " 价格：" + product.getPrice());
                    // 改标识
                    this.product.setFlag(false);
                    // 唤醒所有等待的线程
                    product.notifyAll();
                } else {
                    // 如果产品已经被消费完毕,应该唤醒生产者去生成
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
