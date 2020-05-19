package com.hfm.deadlock;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-07 21:17
 */
public class DeadLockTest {
    public static void main(String[] args) {
        final StringBuffer s1 = new StringBuffer();
        final StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s2.append("A");
                    synchronized (s2) {
                        s2.append("B");
                        System.out.print(s1);
                        System.out.print(s2);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (s2) {
                    s2.append("C");
                    synchronized (s1) {
                        s1.append("D");
                        System.out.print(s2);
                        System.out.print(s1);
                    }
                }
            }
        }.start();
    }
}
