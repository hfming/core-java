package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 同步函数解决线程安全问题
 * @date 2020-05-06 17:03
 */
public class SynchronizationFunctionSaleTicket implements Runnable {
    /**
     * 类共享数据
     */
    private static int num = 50;

    /**
     * 构造函数
     */
    public SynchronizationFunctionSaleTicket() {
        super();
    }

    /**
     * 同步函数，解决线程安全问题
     */
    @Override
    public synchronized void run() {
        while (true) {

            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "号票");
                num--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("售罄了...");
                break;
            }
        }
    }

    public static void main(String[] args) {
        SynchronizationFunctionSaleTicket ticket = new SynchronizationFunctionSaleTicket();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }
}
