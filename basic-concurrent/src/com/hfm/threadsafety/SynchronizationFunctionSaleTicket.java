package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 同步函数解决线程安全问题 实现Runnable 接口
 * @date 2020-05-06 17:03
 */
public class SynchronizationFunctionSaleTicket implements Runnable {
    /**
     * 类共享数据
     */
    private  int num = 100;

    /**
     * 构造函数
     */
    public SynchronizationFunctionSaleTicket() {
        super();
    }


    @Override
    public  void run() {
        while (true) {
            if (sale()) {
                break;
            }
        }
    }
    /**
     * 同步函数，解决线程安全问题
     * 同步锁对象是当前 this 对象
     */
    private synchronized boolean sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "号票");
            num--;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("售罄了...");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SynchronizationFunctionSaleTicket ticket = new SynchronizationFunctionSaleTicket();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }
}
