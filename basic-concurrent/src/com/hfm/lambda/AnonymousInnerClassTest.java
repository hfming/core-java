package com.hfm.lambda;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 匿名内部类
 * @date 2020-05-07 16:10
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        // 匿名内部类
        Runnable task = new Runnable() {
            @Override
            // 覆盖重写抽象方法
            public void run() {
                System.out.println("多线程任务执行！");
            }
        };
        // 启动线程
        new Thread(task).start();
    }
}
