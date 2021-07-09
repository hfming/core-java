package com.hfm.threadfunction;

/**
 * 线程中断
 */
public class InterruptTest {
    public static void main(String[] args) {
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
            while (System.currentTimeMillis() - time < 1000)  {
            }
        }
        System.out.println("Thread exiting under request...");
    }
}