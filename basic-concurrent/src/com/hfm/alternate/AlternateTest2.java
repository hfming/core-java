package com.hfm.alternate;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description join 方式 线程插入
 * @date 2020-06-15 12:05
 */
public class AlternateTest2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A" + ":" + i);
                }
            }
        };
        Thread thread = new Thread(runnable);

        MyThread myThread = new MyThread(thread, "B");

        MyThread myThread1 = new MyThread(myThread, "C");

        myThread1.start();
    }
}

class MyThread extends Thread {
    private Thread thread;
    private String name;

    public MyThread(Thread thread, String name) {
        this.name = name;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.start();
            thread.join();
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ":" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
