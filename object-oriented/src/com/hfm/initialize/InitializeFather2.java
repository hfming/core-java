package com.hfm.initialize;

/**
 * 继承情况下初始化语句的执行顺序
 * 父类
 *
 * @author hfm
 * @version 1.01 2020-03-24 20:30
 * @date 2020/3/24
 */
public class InitializeFather2 {
    /**
     * 父类显示初始化语句
     */
    private String init = "父类显示初始化语句";

    /**
     * 父类静态构造代码块
     */
    static {
        System.out.println("父类静态构造代码块");
    }

    /**
     * 父类构造代码块
     */ {
        System.out.println(init);
        System.out.println("父类构造代码块");
    }

    /**
     * 父类构造函数
     */
    public InitializeFather2() {
        System.out.println("父类构造函数");
    }
}
