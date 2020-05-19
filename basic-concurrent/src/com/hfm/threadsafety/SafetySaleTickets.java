package com.hfm.threadsafety;

/**
 * 线程安全 Demo
 */
public class SafetySaleTickets implements Runnable {
    /**
     * 类共享数据
     */
    private static int num = 100;

    /**
     * 构造函数
     */
    public SafetySaleTickets() {
        super();
    }

    @Override
    public void run() {
        while (true) {
            // 同步代码快，解决线程安全问题
            synchronized ("锁") {
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
    }

    public static void main(String[] args) {
        // 创建Runnable实现类的对象
        SafetySaleTickets saleTickets = new SafetySaleTickets();
        // 创建三个线程对象
        Thread t1 = new Thread(saleTickets, "窗口1");
        Thread t2 = new Thread(saleTickets, "窗口2");
        Thread t3 = new Thread(saleTickets, "窗口3");
        // 调用start方法开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}
