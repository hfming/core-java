package com.hfm.Executors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-21 22:16
 * @Description 自定义线程池
 * @date 2021/6/21
 */
public class MyThreadPool {
    /**
     *任务对列
     */
    private List<Runnable> list = Collections.synchronizedList(new LinkedList<Runnable>());

    /**
     * 当前线程数
     */
    private int threadSize;
    /**
     * 核心线程数
     */
    private int coreThreadSize;
    /**
     * 最大线程数
     */
    private int maxThreadSize;
    /**
     * 任务队列长度
     */
    private int workSize;

    public MyThreadPool() {
    }

    /**
     * 构造函数
     * @param threadSize
     * @param coreThreadSize
     * @param maxThreadSize
     * @param workSize
     */
    public MyThreadPool(int threadSize, int coreThreadSize, int maxThreadSize, int workSize) {
        this.threadSize = threadSize;
        this.coreThreadSize = coreThreadSize;
        this.maxThreadSize = maxThreadSize;
        this.workSize = workSize;
    }

    /**
     * 提交任务
     * @param runnable
     */
    public void submit(Runnable runnable) {
        // 判断当前集合中的任务数目是否超出最大任务数
        if (list.size() > workSize) {

        }else{
            // 加入任务队列
            list.add(runnable);

            execute(runnable);
        }
    }

    /**
     * 执行任务
     * @param runnable
     */
    public void execute(Runnable runnable) {

    }
}
