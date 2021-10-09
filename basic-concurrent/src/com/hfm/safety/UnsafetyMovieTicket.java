package com.hfm.safety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 线程安全问题
 * @date 2020-05-06 21:29
 */
public class UnsafetyMovieTicket implements Runnable {
    /**
     * Runnable 实现类中的成员变量天生具有共享性，原因在于Runnable实现类对象可以被多个线程共享
     */
    private int ticket = 100;

    /**
     * 执行卖票操作
     */
    @Override
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            //有票 可以卖
            if (ticket > 0) {
                //出票操作
                //使用sleep模拟一下出票时间
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);
            } else {
                System.out.println("票已经售罄！");
                break;
            }
        }
    }

    public static void main(String[] args) {
        //创建线程任务对象，多个线程共享的对象
        UnsafetyMovieTicket ticket = new UnsafetyMovieTicket();
        //创建三个窗口对象
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }
}
