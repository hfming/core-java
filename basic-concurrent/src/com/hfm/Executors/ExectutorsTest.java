package com.hfm.Executors;

import com.hfm.createthread.MyCallable;
import com.hfm.createthread.MyRunnable;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-09 16:10
 */
public class ExectutorsTest {

    /**
     * newFixedThreadPool 方法创建一个可重用的固定线程数的线程池。
     * 重载的方法创建一个固定线程数目的线程池并且线程池中的所有线程都使用 ThreadFactory来创建。
     */
    @Test
    public void newFixedThreadPoolTest() throws ExecutionException, InterruptedException {
        /// 创建方式一
        // 1. 使用Executors工具类的newFixedThreadPool方法创建一个可重用的固定线程数的线程池。
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // 2.提交任务 runnable 任务提交有两种方式
        threadPool.submit(new MyRunnable("submit 提交 Runnable"));
        threadPool.execute(new MyRunnable("execute 提交 Runnable"));

        // 也可以提交Callable ，Callable 任务提交方式只有一种
        // Callable 或者 Runnable任务提交后会返回异步计算的结果
        Future<Integer> future = threadPool.submit(new MyCallable("submit 提交 Callable"));

        // get 方法返回异步计算的值
        System.out.println(future.get());

        // 只能加入三个线程，多了没办法加入，与拒绝策略有关
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new MyRunnable("submit 提交 Runnable"));
        }

        /// 创建方式二
        Executors.newFixedThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "自定义线程名称");
            }
        });
        // 拉姆达优化
        Executors.newFixedThreadPool(3, r -> new Thread(new MyRunnable("Runnable")));
    }

    /**
     * newSingleThreadExecutor 创建一个使用单个worker 线程的线程池，以无界队列的方式来运行该线程。
     * 重载的方法创建一个使用单个线程的线程池，线程池中的线程使用ThreadFactory 来创建。
     */
    @Test
    public void newSingleThreadExecutorTest() {
        /// 创建方式异一
        // 1.使用 Executors 工具类的 newSingleThreadExecutor 方法 创建一个使用单个worker 线程的线程池，以无界队列的方式来运行该线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 只有一个线程在执行任务
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new MyRunnable("submit 提交 Runnable"));
        }

        /// 创建方式二
        Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "自定义线程名称");
            }
        });
        // 拉姆达优化
        Executors.newSingleThreadExecutor(r -> new Thread(r, "自定义线程名称"));
    }

    /**
     * newCachedThreadPool 方法创建一个默认的线程池对象，里面的线程是可重用的，且在第一次使用的时候才创建。
     * 重载的方法创建线程池的时候，线程池中所有的线程都使用Thread Factory 来创建，这样线程无需手动启动，自动执行。
     */
    @Test
    public void newCachedThreadPoolTest() throws ExecutionException, InterruptedException {
        /// 创建方式一
        // 1.使用 Executors 工具类的 newCachedThreadPool 方法创建一个默认的线程池对象，里面的线程是可重用的，且在第一次使用的时候才创建。
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 2.提交任务 runnable 任务提交有两种方式
        executorService.submit(new MyRunnable("submit 提交 Runnable"));
        executorService.execute(new MyRunnable("execute 提交 Runnable"));

        // 也可以提交Callable ，Callable 任务提交方式只有一种
        // Callable 或者 Runnable任务提交后会返回异步计算的结果
        Future<Integer> future = executorService.submit(new MyCallable("submit 提交 Callable"));

        // get 方法返回异步计算的值
        System.out.println(future.get());

        /// 创建方式二
        Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "自定义线程名称");
            }
        });
        // 拉姆达优化
        Executors.newCachedThreadPool(r -> new Thread(new MyRunnable("Runnable")));
    }

    /**
     * 关闭线程池的方式
     */
    @Test
    public void shutdownAndshutdownNow() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            threadPool.submit(new Runnable() {
                private String name;

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }

                @Override
                public String toString() {
                    return name;
                }
            });
        }
        // shutdown 关闭线程池，没有返回值，不能再提交任务，但是以前的任务仍然可以执行
//        threadPool.shutdown();

        // shutdownNow  关闭线程池，如果线程池中还有缓存的任务没有执行，就取消还没有执行的任务，并返回任务集合
        List<Runnable> runnables = threadPool.shutdownNow();
        System.out.println(runnables);
    }

    /**
     * newScheduledThreadPool
     */
    @Test
    public void newScheduledThreadPool() {
        // 获具有延迟执行任务的线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        };
//        scheduledExecutorService.submit(runnable);

        // schedule 提交延时任务
        for (int i = 0; i < 10; i++) {

//            scheduledExecutorService.schedule(runnable, 2, TimeUnit.SECONDS);
        }

        // 设置第一次执行与第二此执行的时间间隔
        // comment 任务
        // initialDelay 开始时间
        // Period 时间间隔
        // TimeUnit 时间单位
        scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 3, TimeUnit.SECONDS);

        // 设置第一次结束与第二次开始的时间间隔
        // comment 任务
        // initialDelay 开始时间
        // delay 时间间隔
        // TimeUnit 时间单位
//        scheduledExecutorService.scheduleWithFixedDelay(runnable, 5, 3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
      new ExectutorsTest().newScheduledThreadPool();
    }
}
