package com.hfm.state;

import com.hfm.thread.MyThread;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 15:34
 */
public class ThreadState {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("自定义线程");
        // 线程状态 new
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
    }
}
