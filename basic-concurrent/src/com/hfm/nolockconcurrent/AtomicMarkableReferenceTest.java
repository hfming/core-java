package com.hfm.nolockconcurrent;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-16 21:27
 * @Description 添加版本号
 * @date 2021/9/16
 */
public class AtomicMarkableReferenceTest {
    static AtomicMarkableReference<String> ref = new AtomicMarkableReference<>("A",false);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        // 获取值 A
        String prev = ref.getReference();
        System.out.println("A的值"+ prev);

        // 如果中间有其它线程干扰，发生了 ABA 现象
        other();
        Thread.sleep(4);
        // 尝试改为 C
        System.out.println("change A->C " + ref.compareAndSet(prev, "C",true,false));
    }

    private static void other() {
        new Thread(() -> {
            System.out.println("change A->B {}" + ref.compareAndSet(ref.getReference(), "B", true,false));
        }, "t1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("change B->A " + ref.compareAndSet(ref.getReference(), "A", false,true));
        }, "t2").start();
    }
}
