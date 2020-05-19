package com.hfm.comunication;

/**
 * 生产者类
 *
 * @author hfm
 */
public class Producer extends Thread {
    private Product product = null;

    /**
     * 构造函数
     */
    public Producer() {
    }

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (this.product) {
                boolean flag = this.product.isFlag();
                if (flag == false) {
                    if (i % 2 == 0) {
                        this.product.setName("摩托车");
                        this.product.setPrice(5000.00);
                    } else {
                        this.product.setName("自行车");
                        this.product.setPrice(300.00);
                    }
                    i++;
                    this.product.setFlag(true);
                    // 唤醒消费者去消费
                    this.product.notifyAll();
                } else {
                    try {
                        this.product.wait(10000, 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
