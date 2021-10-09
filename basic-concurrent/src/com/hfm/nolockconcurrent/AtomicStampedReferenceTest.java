package com.hfm.nolockconcurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-16 21:27
 * @Description 添加版本号
 * @date 2021/9/16
 */
public class AtomicStampedReferenceTest {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        // 获取值 A
        String prev = ref.getReference();
        System.out.println("A的值" + prev);
        // 获取版本号
        int stamp = ref.getStamp();
        System.out.println("版本" + stamp);

        // 如果中间有其它线程干扰，发生了 ABA 现象
        other();
        Thread.sleep(2);
        // 尝试改为 C
        System.out.println("change A->C " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
    }

    private static void other() {
        new Thread(() -> {
            System.out.println("change A->B {}" + ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 " + ref.getStamp());
        }, "t1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("change B->A " + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 {}" + ref.getStamp());
        }, "t2").start();
    }
}
