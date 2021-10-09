package com.hfm.nolockconcurrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-16 21:27
 * @Description
 * @date 2021/9/16
 */
public class AtomicReferenceTest {
    AtomicReference<BigDecimal> ref;

    public AtomicReferenceTest(BigDecimal balance) {
        ref = new AtomicReference<BigDecimal>(balance);
    }

    /**
     * 获取余额
     *
     * @return
     */
    public BigDecimal getBalance() {
        return ref.get();
    }

    /**
     * 取款
     *
     * @param amount
     */
    public void withdraw(BigDecimal amount) {
        while (true) {
            BigDecimal prev = ref.get();
            BigDecimal next = prev.subtract(amount);
            if (ref.compareAndSet(prev, next)) {
                break;
            }
        }
    }

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    public static void demo(AtomicReferenceTest account) {
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(BigDecimal.TEN);
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
        System.out.println(account.getBalance());
    }

    public static void main(String[] args) {
        AtomicReferenceTest.demo(new AtomicReferenceTest(new BigDecimal(10000)));
    }
}
