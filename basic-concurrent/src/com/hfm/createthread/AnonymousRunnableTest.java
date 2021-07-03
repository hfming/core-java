package com.hfm.createthread;

import org.junit.jupiter.api.Test;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 通过匿名内部类实现自定义线程
 * @date 2020-05-06 21:19
 */
public class AnonymousRunnableTest {
    @Test
    public  void anonymousRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类方式创建线程");
            }
        }).start();

        // 拉姆达表达式优化
        new Thread(() -> System.out.println("拉姆达表达式优化")).start();
    }
}
