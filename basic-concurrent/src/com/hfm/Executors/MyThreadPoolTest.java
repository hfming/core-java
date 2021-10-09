package com.hfm.Executors;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-21 22:16
 * @Description 自定义线程池
 * @date 2021/6/21
 */
public class MyThreadPoolTest {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 10, 5, 50, TimeUnit.MILLISECONDS);

        for (int i = 0; i < 15; i++) {
            int j = i;
            myThreadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

/**
 * 自定义线程池
 */
class MyThreadPool {
    /**
     * 任务对列
     */
    private MyBlockingQueue<Runnable> myBlockingQueue;
    /**
     * 任务集合
     */
    private HashSet<Worker> workers = new HashSet<>();
    /**
     * 核心线程数
     */
    private int coreThreadSize;
    /**
     * 最大线程数
     */
    private int maxThreadSize;
    /**
     * 任务队列长度
     */
    private int workSize;
    /**
     * 超时时间
     */
    private long timeOut;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    /**
     * 构造函数
     *
     * @param coreThreadSize
     * @param maxThreadSize
     * @param workSize
     * @param timeOut
     * @param timeUnit
     */
    public MyThreadPool(int coreThreadSize, int maxThreadSize, int workSize, long timeOut, TimeUnit timeUnit) {
        this.coreThreadSize = coreThreadSize;
        this.maxThreadSize = maxThreadSize;
        this.workSize = workSize;
        this.myBlockingQueue = new MyBlockingQueue<>(workSize);
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
    }

    /**
     * 默认拒绝策略
     */
    private RejectPolicy<Runnable> rejectPolicy = (queue, task) -> {
        System.out.println("超出最大线程数");
    };

    /**
     * 执行任务
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
        synchronized (workers) {
            if (workers.size() <= maxThreadSize) {
                Worker worker = new Worker(runnable);
                workers.add(worker);
                // 如果小于核心线程数，则执行任务
                if (workers.size() <= coreThreadSize) {
                    worker.start();
                } else if (workers.size() <= (workSize + coreThreadSize)) {
                    // 如果大于核心线程数，小于任务队列加入到任务队列中
                    myBlockingQueue.put(runnable);
                } else if (workers.size() <= maxThreadSize) {
                    // 如果大于任务对象，小于最大线程数，创建非核心线程执行任务
//                    new Thread(runnable).start();
                    // 这里是等待加入任务队列
                    myBlockingQueue.offer(runnable, 10, TimeUnit.MILLISECONDS);
                }
            } else {
                // 如果大于最大线程数，执行拒绝策略
                myBlockingQueue.tryPut(rejectPolicy, runnable);
            }
        }
    }

    private class Worker extends Thread {
        private Runnable runnable;

        public Worker(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            // 执行任务
            // 1) 当 task 不为空，执行任务
            // 2) 当 task 执行完毕，再接着从任务队列获取任务并执行
            while (runnable != null || (runnable = myBlockingQueue.poll(timeOut, timeUnit)) != null) {
                try {
                    System.out.println(runnable + "正在执行");
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    runnable = null;
                }
                synchronized (workers) {
                    System.out.println(this + "被移除");
                    workers.remove(this);
                }
            }
        }
    }
}

/**
 * 拒绝策略接口
 *
 * @param <T>
 */
@FunctionalInterface
interface RejectPolicy<T> {
    void reject(MyBlockingQueue<T> queue, T task);
}

/**
 * 自定义任务队列
 *
 * @param <T>
 */
class MyBlockingQueue<T> {
    /**
     * 任务队列
     */
    private Deque<T> queue = new ArrayDeque<>();

    /**
     * 锁
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * 生产者条件变量
     * 用于唤醒消费者线程
     */
    private Condition fullWaitSet = lock.newCondition();

    /**
     * 消费者条件变量
     * 用于唤醒生产者线程
     */
    private Condition emptyWaitSet = lock.newCondition();

    /**
     * 容量
     */
    private int capcity;

    /**
     * 构造函数
     *
     * @param capcity
     */
    public MyBlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    /**
     * 阻塞获取
     *
     * @return
     */
    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            // 唤醒生产者消费者线程
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 带超时阻塞获取
     *
     * @param timeout
     * @param unit
     * @return
     */
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            // 将 timeout 统一转换为 纳秒
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()) {
                try {
                    // 返回值是剩余时间
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞添加
     *
     * @param task
     */
    public void put(T task) {
        lock.lock();
        try {
            while (queue.size() == capcity) {
                try {
                    System.out.println("等待加入任务队列" + task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加入任务队列" + task);
            queue.addLast(task);
            emptyWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 带超时时间阻塞添加
     *
     * @param task
     * @param timeout
     * @param timeUnit
     * @return
     */
    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capcity) {
                try {
                    if (nanos <= 0) {
                        return false;
                    }
                    System.out.println("等待加入任务队列" + task);
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加入任务队列" + task);
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 拒绝方法
     *
     * @param rejectPolicy
     * @param task
     */
    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            // 判断队列是否满
            if (queue.size() == capcity) {
                rejectPolicy.reject(this, task);
            } else {  // 有空闲
                System.out.println("加入任务队列" + task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
