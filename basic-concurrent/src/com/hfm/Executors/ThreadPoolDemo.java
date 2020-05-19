package com.hfm.Executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-09 18:09
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1.获取线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.submit(new MyCallable("客户" + i));
        }

    }
}

class MyCallable implements Callable {
    /**
     * 秒杀商品数目
     */
    private static int num = 10;
    /**
     * 线程名称
     */
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        if (num > 0) {
            synchronized (this) {
                if (num > 0) {
                    System.out.println(name + "恭喜你抢到了秒杀商品");
                    num--;
                    return true;
                }
            }
        }
        System.out.println(name+ "很遗憾，没有抢到了秒杀商品");
        return false;
    }
}
