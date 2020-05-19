package com.hfm.lambda;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 拉姆达表达式
 * @date 2020-05-07 16:11
 */
public class LamdbaTest {
    public static void main(String[] args) {
        // 启动线程
        new Thread(() -> System.out.println("多线程任务执行！")).start();
    }
}
