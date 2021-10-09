package com.hfm.function;

import org.junit.jupiter.api.Test;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-12 19:21
 * @Description
 * @date 2021/9/12
 */
public class StartAndRun {
    /**
     * start 方法测试
     * start 可以开启一个线程，并让JVM 自动执行run 方法
     */
    @Test
    public void start(){
        new Thread(() -> System.out.println(Thread.currentThread().getName()), "自定义线程").start();

        System.out.println(Thread.currentThread().getName());
    }

    /**
     * run 方法测试
     * run 方法不会开启一个线程
     */
    @Test
    public void run(){
        Thread thread = new Thread("自定义线程") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread.run();

        System.out.println(Thread.currentThread().getName());
    }
}
