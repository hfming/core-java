package com.hfm.safety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 21:39
 */
public class SafetyMovieTicket implements Runnable {
    private int ticket = 100;
    private Object lock = new Object();

    /**
     * 执行卖票操作
     */
    @Override
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            // 同步代码块
            synchronized (lock) {
                //有票 可以卖
                if (ticket > 0) {
                    //出票操作
                    //使用sleep模拟一下出票时间
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //获取当前线程对象的名字
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖第:" + ticket-- + "号票");
                } else {
                    System.out.println("票已经售罄！");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程任务对象
        SafetyMovieTicket ticket = new SafetyMovieTicket();
        // 创建三个窗口对象
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }
}
