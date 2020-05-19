package com.hfm.threadsafety;

/**
 * 购票多线程
 *
 * @author hfm
 */
public class SafetySaleTicketsThread extends Thread {
    /**
     * 类共享数据
     */
    private static int ticketNum = 500;

    /**
     * 构造函数
     */
    public SafetySaleTicketsThread() {
        super();
    }

    public SafetySaleTicketsThread(String name) {
        super(name);
    }

    /**
     * 线程的run方法中编写线程运行的方法
     */
    @Override
    public void run() {
        while (true) {
            // 同步代码块，防止线程安全问题
            synchronized (this.getClass()) {
                if (ticketNum > 0) {
                    ticketNum--;
                    System.out.println(this.getName() + "卖了一张票，剩余" + ticketNum + "张");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("售罄了");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new SafetySaleTicketsThread("1").start();
        new SafetySaleTicketsThread("2").start();
        new SafetySaleTicketsThread("3").start();
    }
}
