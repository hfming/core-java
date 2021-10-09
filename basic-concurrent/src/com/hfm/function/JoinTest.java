package com.hfm.function;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-12 16:43
 * @Description
 * @date 2021/9/12
 */
public class JoinTest {
    public static void main(String[] args) {
        new MotherThread().start();
    }
}

/**
 * 线程插入
 * Join 方法
 */
class MotherThread extends Thread {
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
}

/**
 * 加入的线程
 */
class SonThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("儿子下楼梯");
            Thread.sleep(1000);
            System.out.println("儿子一直往前走...");
            System.out.println("儿子买到了酱油...");
            System.out.println("儿子跑回来...");
            Thread.sleep(1000);
            System.out.println("儿子把酱油给老妈..");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
