package com.hfm.nolockconcurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-17 11:59
 * @Description
 * @date 2021/9/17
 */

public class MyAtomicTest {
    public static void main(String[] args) {
        Account.demo(new MyAtomic(10000));
    }

    static class MyAtomic implements Account {
        /**
         * CAS 要与 volatile 配合使用
         */
        private volatile int value;
        /**
         * 内部的 UNSAFE 对象
         */
        private static final Unsafe UNSAFE;
        /**
         * 偏移量
         */
        private static final long VALUEOFFSET;

        static {
            try {
                // 反射反射获取 Unsafe 对象
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                UNSAFE = (Unsafe) theUnsafe.get(null);

                // 获取 value 字段偏移量
                VALUEOFFSET = UNSAFE.objectFieldOffset(MyAtomic.class.getDeclaredField("value"));

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public MyAtomic(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        /**
         * 获取然后更新
         *
         * @param updateFunction
         * @return
         */
        public int getAndUpdate(IntUnaryOperator updateFunction) {
            int prev = getValue(), next = 0;
            for (boolean haveNext = false; ; ) {
                if (!haveNext) {
                    next = updateFunction.applyAsInt(prev);
                }
                if (UNSAFE.compareAndSwapInt(this, VALUEOFFSET, prev, next)) {
                    return prev;
                }
                haveNext = (prev == (prev = getValue()));
            }
        }

        /**
         * 更新然后获取
         *
         * @param updateFunction
         * @return
         */
        public int updateAndGet(IntUnaryOperator updateFunction) {
            int prev = getValue(), next = 0;
            for (boolean haveNext = false; ; ) {
                if (!haveNext) {
                    next = updateFunction.applyAsInt(prev);
                }
                if (UNSAFE.compareAndSwapInt(this, VALUEOFFSET, prev, next)) {
                    return next;
                }
                haveNext = (prev == (prev = getValue()));
            }
        }

        @Override
        public Integer getBalance() {
            return getValue();
        }

        @Override
        public void withdraw(Integer amount) {
            updateAndGet(num -> num -amount);
        }
    }

    interface Account {
        /**
         * 获取余额
         *
         * @return
         */
        Integer getBalance();

        /**
         * 取款
         *
         * @param amount
         */
        void withdraw(Integer amount);

        /**
         * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
         * 如果初始余额为 10000 那么正确的结果应当是 0
         */
        static void demo(Account account) {
            List<Thread> ts = new ArrayList<>();
            long start = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                ts.add(new Thread(() -> {
                    account.withdraw(10);
                }));
            }
            ts.forEach(Thread::start);
            ts.forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            long end = System.nanoTime();
            System.out.println(account.getBalance() + " cost: " + (end - start) / 1000_000 + " ms");
        }
    }
}

