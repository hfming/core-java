package com.hfm.safety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 线程安全问题
 * @date 2020-05-06 21:29
 */
public class UnsafetyMovieTicketThread extends Thread {
    /**
     * Thread 子类创建的线程，成员变量为 static 静态的才会出现线安全问题
     * 原因在于每一个 Thread 子类对象的非静态成员是私有的，只有静态成员是所有 Thread 共享的
     */
    private static int ticket = 100;

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
        //创建线程对象
        new UnsafetyMovieTicketThread().start();
        new UnsafetyMovieTicketThread().start();
        new UnsafetyMovieTicketThread().start();
    }
}
