package com.hfm.nolockconcurrent;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-16 19:37
 * @Description
 * @date 2021/9/16
 */
public class NoLockDemo {
    public static void main(String[] args) {
//        Account.demo(new AccountUnsafe(10000));
//        Account.demo(new AccountSafe(10000));
        Account.demo(new AccountSafe2(10000));
    }
}

/**
 * 无锁方式解决线程安全问题
 */
class AccountSafe2 implements Account {
    /**
     * 原子类
     */
    private AtomicInteger balance;

    public AccountSafe2(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            // CAS 算法
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount);
    }
}

/**
 * 加锁方式解决线程安全我问题
 */
class AccountSafe implements Account {
    private Integer balance;

    public AccountSafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public synchronized Integer getBalance() {
        return balance;
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        balance -= amount;
    }
}

/**
 * 线程不安全
 */
class AccountUnsafe implements Account {
    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        balance -= amount;
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