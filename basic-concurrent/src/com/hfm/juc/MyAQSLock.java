package com.hfm.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-18 10:41
 * @Description
 * @date 2021/9/18
 */
public class MyAQSLock implements Lock {
    private MySych mySych = new MySych();

    /***
     * 自定义 AQS
     */
    private class MySych extends AbstractQueuedSynchronizer {
        /**
         * 尝试加锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                // 加锁，锁的拥有者为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 是否是独占锁
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 获取条件变量
         *
         * @return
         */
        public Condition newzCondition() {
            return new ConditionObject();
        }
    }

    /**
     * 加锁
     */
    @Override
    public void lock() {
        mySych.acquire(1);
    }

    /**
     * 加锁中断
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        mySych.acquireInterruptibly(1);
    }

    /**
     * 尝试加锁
     *
     * @return
     */
    @Override
    public boolean tryLock() {
        return mySych.tryAcquire(1);
    }

    /**
     * 固定时间尝试加锁
     *
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySych.tryAcquireNanos(1, unit.toNanos(time));
    }

    /**
     * 解锁
     */
    @Override
    public void unlock() {
        mySych.release(1);
    }

    /**
     * 条件变量
     *
     * @return
     */
    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {
        MyAQSLock myAQSLock = new MyAQSLock();

        new Thread(() -> {
            myAQSLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获取锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myAQSLock.unlock();
            }
        },"线程 A").start();

        new Thread(() -> {
            myAQSLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获取锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myAQSLock.unlock();
            }
        },"线程 B").start();
    }
}
