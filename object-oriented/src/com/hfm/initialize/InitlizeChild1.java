package com.hfm.initialize;

/**
 * 继承情况下初始化语句的执行顺序
 * 子类
 *
 * @author hfm
 * @version 1.01 2020-03-24 20:34
 * @date 2020/3/24
 */
public class InitlizeChild1 extends InitializeFather1 {
    /**
     * 子类静态构造代码块
     */
    static {
        System.out.println("子类静态构造代码块");
    }

    /**
     * 子类构造代码块
     */ {
        System.out.println("子类构造代码块");
    }

    /**
     * 子类构造函数
     */
    public InitlizeChild1() {
        System.out.println("子类构造函数");
    }
}
