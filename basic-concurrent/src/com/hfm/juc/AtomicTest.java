package com.hfm.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-14 21:16
 */
public class AtomicTest {
    public static void main(String[] args) {
//        AtomicThread atomicThread = new AtomicThread();
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(atomicThread).start();
//        }

        AtomicThread2 atomicThread2 = new AtomicThread2();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicThread2).start();
        }
    }
}

class AtomicThread implements Runnable{
    private int serialNum =0;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNum());
    }

    public int getSerialNum() {
        return serialNum++;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }
}

class AtomicThread2 implements Runnable{
    private AtomicInteger serialNum = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNum());
    }

    public int getSerialNum() {
        return serialNum.getAndIncrement();
    }

    public void setSerialNum(AtomicInteger serialNum) {
        this.serialNum = serialNum;
    }
}