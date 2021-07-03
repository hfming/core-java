package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 同步函数解决线程安全问题
 * @date 2020-05-06 17:03
 */
public class SynchronizationFunctionMovieTicket implements Runnable {
    private int ticket = 100;

    /**
     * 执行卖票操作
     */
    @Override
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            if (sellTicket()) {
                break;
            }
        }
    }

    /**
     * 锁对象是谁调用这个方法就是谁
     * 隐含锁对象就是 this
     */
    public synchronized boolean sellTicket() {
        // 有票 可以卖
        if (ticket > 0) {
            // 出票操作
            // 使用sleep模拟一下出票时间
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取当前线程对象的名字
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在卖:" + ticket--);
            return false;
        } else {
            System.out.println("票已经售罄！");
            return true;
        }
    }

    public static void main(String[] args) {
        SynchronizationFunctionMovieTicket ticket = new SynchronizationFunctionMovieTicket();
        new Thread(ticket, "1").start();
        new Thread(ticket, "2").start();
        new Thread(ticket, "3").start();
    }
}
