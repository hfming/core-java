package com.hfm.Executors;

import com.hfm.create.MyRunnable;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description ThreadPoolExecutor 创建线程池
 * @date 2020-05-08 13:08
 */
public class ThreadPoolExecutorTest {
    @Test
    public void threadPoolExecutorTest() {
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

    @Test
    public void threadPoolExecutorTest2() throws IOException {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        // 预启动所有核心线程
        executor.prestartAllCoreThreads();

        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }
        // 阻塞主线程
        System.in.read();
    }

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }

    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                // 让任务执行慢点
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
