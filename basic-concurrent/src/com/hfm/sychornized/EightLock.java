package com.hfm.sychornized;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-06-15 14:54
 */
public class EightLock {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        Number number3 = new Number();

        new Thread(() -> number1.getOne()).start();
        new Thread(() -> number2.getTwo()).start();
        new Thread(() -> number3.getThree()).start();
    }
}

class Number {
    public static synchronized void getOne() {
        try {
            Thread.sleep(1000);
            System.out.println("one");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public   void getThree() {
        System.out.println("three");
    }
}