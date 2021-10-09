package com.hfm.create;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-07 17:08
 */
public class MyThreadTest {
    public static void main(String[] args) {
        new OddNumber("奇数").start();
        new EvenNumber("偶数").start();
    }
}

/**
 * 奇数
 */
class OddNumber extends Thread {
    public OddNumber(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }
}

/**
 * 偶数
 */
class EvenNumber extends Thread {
    public EvenNumber(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }
}