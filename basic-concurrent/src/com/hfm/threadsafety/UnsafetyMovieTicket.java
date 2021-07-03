package com.hfm.threadsafety;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 21:29
 */
public class UnsafetyMovieTicket implements Runnable {
    private  int ticket = 100;

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
            }else{
                System.out.println("票已经售罄！");
                break;
            }
        }
    }

    public static void main(String[] args) {
        //创建线程任务对象
        UnsafetyMovieTicket ticket = new UnsafetyMovieTicket();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        //同时卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
