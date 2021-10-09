package com.hfm.function;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-12 19:31
 * @Description
 * @date 2021/9/12
 */
public class SleepTest {
    @Test
    public void sleep(){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10000; i++) {
//                System.out.println(i);
            }
        },"自定义线程");
        thread.start();
        System.out.println(thread.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

    /**
     * 使用 Interrupt 打断 sleep 会抛出一个错误
     */
    @Test
    public void sleepInterrupt(){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10000; i++) {
//                System.out.println(i);
            }
        },"自定义线程");
        thread.start();
        System.out.println(thread.getState());

        try {
            Thread.sleep(500);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }

    /**
     * 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性
     */
    @Test
    public void timeUnitSleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *在没有利用 cpu 来计算时，不要让 while(true) 空转浪费 cpu，这时可以使用 yield 或 sleep 来让出 cpu 的使用权给其他程序。
     */
    @Test
    public void sleepUse(){
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
