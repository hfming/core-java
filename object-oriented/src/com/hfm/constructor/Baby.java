package com.hfm.constructor;

import java.util.Date;

/**
 * 构造函数 demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 21:22
 * @date 2020/3/26
 */
public class Baby {
    /**
     * 成员变量
     */
    private int height;
    /**
     * 成员变量
     */
    private Date time;

    /**
     构造代码块
     *
     */ {
        cry();
    }

    /**
     * 无参构造函数
     */
    public Baby() {

    }

    /**
     * 全参构造函数
     */
    public Baby(int height, Date time) {
        this.height = height;
        this.time = time;
    }

    /**
     * 公共方法
     */
    public void cry() {
        // 私有方法之内本类使用
        eat();
        System.out.println("baby cry!");
    }

    /**
     * 私有方法
     */
    private void eat() {
        System.out.println("eat!");
    }
}
