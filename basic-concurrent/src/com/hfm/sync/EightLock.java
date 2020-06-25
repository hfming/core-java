package com.hfm.sync;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-15 14:54
 */
public class EightLock {
    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getTwo();
            }
        }).start();
    }
}

class Number {
    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
            System.out.println("one");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}