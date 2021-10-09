package com.hfm.nolockconcurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 21:16
 */
public class AtomicTest {
    public static void main(String[] args) {
//        NotAtomicThread notAtomicThread = new NotAtomicThread();
//        for (int i = 0; i < 10; i++) {
//            new Thread(notAtomicThread).start();
//        }

        // 原子性操作
        AtomicThread atomicThread = new AtomicThread();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicThread).start();
        }
    }
}

class NotAtomicThread implements Runnable {
    private int serialNum = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(getSerialNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSerialNum() {
        return serialNum++;
    }
}

class AtomicThread implements Runnable {
    private AtomicInteger serialNum = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(getSerialNum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSerialNum() {
        return serialNum.getAndIncrement();
    }
}