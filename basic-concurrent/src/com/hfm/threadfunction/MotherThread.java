package com.hfm.threadfunction;

/**
 * 线程插入
 * Join 方法
 */
public class MotherThread extends Thread {
    @Override
    public void run() {
        System.out.println("妈妈洗菜...");
        System.out.println("妈妈切菜...");
        System.out.println("妈妈发现没有酱油了...");
        // 通知儿子去打酱油
        SonThread s = new SonThread();
        s.start();
        try {
            // join 加入线程方法：如果当前线程执行了join方法，那么当前线程就会让步给新加入的线程先完成任务，然后当前线程才继续的执行自己的任务。
            s.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("妈妈炒菜...");
        System.out.println("全家一起吃饭...");
    }

    public static void main(String[] args) {
        MotherThread motherThread = new MotherThread();
        motherThread.start();
    }
}
