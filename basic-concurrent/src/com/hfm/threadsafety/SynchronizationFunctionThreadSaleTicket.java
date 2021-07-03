package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 同步函数解决线程安全问题 继承 Thread
 * @date 2020-05-06 17:03
 */
public class SynchronizationFunctionThreadSaleTicket extends Thread {
    /**
     * 类共享数据
     */
    private static int num = 100;

    /**
     * 构造函数
     */
    public SynchronizationFunctionThreadSaleTicket() {
        super();
    }


    @Override
    public void run() {
        while (true) {
            if (sale()) {
                break;
            }
        }
    }

    /**
     * 同步函数，解决线程安全问题
     * 当前锁对象是类对象 静态的是在方法区中的类对象
     */
    private static synchronized boolean sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "号票");
            num--;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            System.out.println("售罄了...");
            return true;
        }
    }

    public static void main(String[] args) {
        SynchronizationFunctionThreadSaleTicket ticket1 = new SynchronizationFunctionThreadSaleTicket();
        SynchronizationFunctionThreadSaleTicket ticket2 = new SynchronizationFunctionThreadSaleTicket();
        SynchronizationFunctionThreadSaleTicket ticket3 = new SynchronizationFunctionThreadSaleTicket();

        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}
