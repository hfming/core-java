package com.hfm.function;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程中断
 */
public class InterruptTest {
    /**
     * stop 方法的问题
     */
    @Test
    public void stop() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
                // 如果当前线程已经死亡或者中断则退出循环
                if (!Thread.currentThread().isAlive() || Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().isAlive());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        }, "Stop 方法的问题");
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void interrupt() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
                // 如果当前线程已经死亡或者中断则退出循环
                if (!Thread.currentThread().isAlive() || Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().isAlive());
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        }, "interrupt 方法中断");
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 两阶段终止模式
     */
    @Test
    public void twoPhaseTermination(){
        Thread thread = new Thread(() -> {
            while (true){
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }

                try {
                    // 睡眠时被打断,进入异常处理
                    TimeUnit.MILLISECONDS.sleep(1000);
                    // 正常被打断,再次进入循环 料理后事
                    System.out.println("将结果保存");
                } catch (InterruptedException e) {
                    // InterruptedException 会将打断标记变成 false
                    // 重新设置中断标志,再次进入循环 料理后事
                    Thread.currentThread().interrupt();
                }
            }
        }, "两阶段终止模式");
        thread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(3500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * LockSupport.park(); 终止一个线程
     */
    @Test
    public void park(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                if (i == 5000) {
                    // 打断之前执行
                    System.out.println(i);
                    LockSupport.park();
                    // 打断之后不执行
                    System.out.println(i);
                }
            }
        }, "interrupt 方法中断");
        thread.start();
    }

    @Test
    public void interrupt2() {
        Thread thread = new Thread(new InterruptRunnable());
        System.out.println("Starting thread...");
        thread.start();

        try {
            Thread.sleep(3000);
            System.out.println("Asking thread to stop...");
            // 发出中断请求
            // 可以指定清除那个线程。
            thread.interrupt();
            Thread.sleep(3000);
            System.out.println("Stopping application...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class InterruptRunnable implements Runnable {
    @Override
    public void run() {
        long time;
        // 每隔一秒检测是否设置了中断标示
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread is running...");
            time = System.currentTimeMillis();
            // 使用while循环模拟 sleep
            while (System.currentTimeMillis() - time < 1000) {
            }
        }
        System.out.println("Thread exiting under request...");
    }
}