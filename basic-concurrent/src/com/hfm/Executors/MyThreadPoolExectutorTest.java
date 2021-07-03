package com.hfm.Executors;

import com.hfm.createthread.MyRunnable;

import java.util.concurrent.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-08 21:20
 */
public class MyThreadPoolExectutorTest {
    public static void main(String[] args) {
        // 核心s线程数目 设置为8
        //  一般按照8020原则设计，即80%情况设计核心数目，剩余20%可以利用最大线程数进行处理。
        int corePoolSize = 8;
        // 最大线程数目设置为10
        // 最大线程数目=(最大任务数目-做任务队列长度)*单个任务时间；即最大线程数目=(1000-200)*0.1=80
        int maximuPoolSize = 80;
        // 最大空闲时间 默认为 60S
        long keepAliveTime = 60L;
        // 时间单位默认设置为秒
        TimeUnit seconds = TimeUnit.SECONDS;
        // 任务队列设置为 200
        // 核心线程数/单个任务执行时间*2
        ArrayBlockingQueue workQueue = new ArrayBlockingQueue(200);
        // 线程创建工厂 使用默认工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 拒绝策略使用 延时策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximuPoolSize, keepAliveTime, seconds, workQueue, handler);

        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.submit(new MyRunnable("线程" + i));
        }
        threadPoolExecutor.shutdown();
    }
}
