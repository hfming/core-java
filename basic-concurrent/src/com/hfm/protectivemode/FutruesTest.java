package com.hfm.protectivemode;

import java.util.concurrent.TimeUnit;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 17:31
 * @Description
 * @date 2021/9/14
 */
public class FutruesTest {
    public static void main(String[] args) {
        // 等待者
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "等待结果");
                // 通过 id 获取保护者
                GuardedObjectId guardedObjectById = Futures.getGuardedObjectById(id);

                // 保护者获取结果
                Object o = guardedObjectById.get();
                System.out.println(o);
                System.out.println(Thread.currentThread().getName() + "已经接收结果");
            }, "等待者" + i + "号").start();
        }

        // 生产者
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                GuardedObjectId guardedObjectId = Futures.createGuardedObjectId();
                try {
                    TimeUnit.SECONDS.sleep(3);
                    guardedObjectId.complete(Thread.currentThread().getName() + "生产产品");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "生产者" + i + "号").start();
        }
    }
}
