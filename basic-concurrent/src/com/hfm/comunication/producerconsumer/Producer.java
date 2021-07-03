package com.hfm.comunication.producerconsumer;

/**
 * 生产者类
 *
 * @author hfm
 */
public class Producer extends Thread {
    private Product product = null;

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
                        product.setName("摩托车");
                        product.setPrice(5000.00);
                    } else {
                        product.setName("自行车");
                        product.setPrice(300.00);
                    }
                    i++;
                    System.out.println("生产者生产了" + product.getName() + ":" + product.getPrice());
                    product.setFlag(true);
                    // 唤醒消费者去消费
                    product.notifyAll();
                } else {
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
