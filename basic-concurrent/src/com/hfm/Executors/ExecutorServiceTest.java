package com.hfm.Executors;

import com.hfm.createthread.MyRunnable;

import java.util.concurrent.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-08 12:24
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /// 1. 通过继承Thread 类，创建Thread 类的子类，创建自定义线程类
        new TestThread("继承 Thread 类").start();

        /// 2. 通实现 Runnable 接口，重写 run 方法，创建自定义线程类
        new Thread(new TestRunnable(), "Runnable 实现类对象").start();

        /// 3.通过实现 Callable 接口，重写 call 方法,创建 FutureTask 对象，创建自定义线程类
        FutureTask futureTask = new FutureTask<>(new TestCallabel());
        new Thread(futureTask, "Callable 实现类对象").start();
        System.out.println(futureTask.get());

        /// 4.通过线程池获取线程
        // 线程池不允许使用Executors去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
        // 说明：Executors返回的线程池对象的弊端如下：
        // 1）FixedThreadPool和SingleThreadPool:允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
        // 2）CachedThreadPool:允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service;
        // 管理线程池,设置 核心池大小
        threadPoolExecutor.setCorePoolSize(2 << 4);
        // 设置最大线程数目
        threadPoolExecutor.setMaximumPoolSize(2 << 5);
        // 设置没有任务时最长保存时间
        threadPoolExecutor.setKeepAliveTime(1000, TimeUnit.SECONDS);

        //  调用 Runnable 线程 方式一
        service.execute(new TestRunnable());
        // 调用 Runnable 线程 方式二
        service.submit(new TestRunnable());

        // 调用 Callabel 线程
        Future submit = service.submit(new TestCallabel());
        System.out.println(submit.get());

        // 关闭线程池
        service.shutdown();

        // 线程池不允许使用Executors去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
        // 说明：Executors返回的线程池对象的弊端如下：
        // 1）FixedThreadPool和SingleThreadPool:允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
        // 2）CachedThreadPool:允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
         ExecutorService service2 = Executors.newFixedThreadPool(10);
        // 创建Runnable实例对象
        MyRunnable r = new MyRunnable("MyRunnable");
        // 自己创建线程对象的方式
        // Thread t = new Thread(r);
        // t.start(); ‐‐‐> 调用MyRunnable中的run()
        // 从线程池中获取线程对象,然后调用MyRunnable中的run()
        service2.submit(r);
        // 再获取个线程对象，调用MyRunnable中的run()
        service2.submit(r);
        service2.submit(r);
        // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
        // 将使用完的线程又归还到了线程池中
        // 关闭线程池,清空线程池中所有线程，再次提交线程任务会报错
        service2.shutdown();

        //  java.util.concurrent.RejectedExecutionException 线程池已经清空，没有线程可以调用，再次提交线程任务会报错
        // service.submit(r);
    }
}

/**
 * 自定义 Runnable 实现类
 */
class TestRunnable implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ":sum = " + sum);
    }
}

/**
 * 自定义 Callable 实现类
 */
class TestCallabel implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + ":sum = " + sum;
    }
}

/**
 * 自定义 Thread 子类
 */
class TestThread extends Thread {
    private String name;

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + ":sum = " + sum);
    }
}