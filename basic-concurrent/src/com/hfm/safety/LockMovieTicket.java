package com.hfm.safety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 21:58
 */
public class LockMovieTicket implements Runnable {
    private int ticket = 100;
    /**
     * 创建一个锁对象
     */
    private Lock lock = new ReentrantLock();

    /**
     * 执行卖票操作
     */
    @Override
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            // 在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁。
            // 说明一：如果在lock方法与try代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
            // 说明二：如果lock方法在try代码块之内，可能由于其它方法抛出异常，导致在finally代码块中，unlock对未加锁的对象解锁，它会调用AQS的tryRelease方法（取决于具体实现类），抛出IllegalMonitorStateException异常。
            // 说明三：在Lock对象的lock方法实现中可能抛出unchecked异常，产生的后果与说明二相同。 java.concurrent.LockShouldWithTryFinallyRule.rule.desc
            lock.lock();
            try {
                //有票 可以卖
                if (ticket > 0) {
                    //出票操作
                    //使用sleep模拟一下出票时间
                    Thread.sleep(50);
                    //获取当前线程对象的名字
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖:" + ticket--);
                } else {
                    System.out.println("票已经售罄！");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockMovieTicket lockMovieTicket = new LockMovieTicket();
        new Thread(lockMovieTicket, "窗口1").start();
        new Thread(lockMovieTicket, "窗口2").start();
        new Thread(lockMovieTicket, "窗口3").start();
    }
}
