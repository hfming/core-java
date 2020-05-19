package com.hfm.anonymous;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 21:19
 */
public class AnonymousRunnableTest {
    public static void main(String[] args) {
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
