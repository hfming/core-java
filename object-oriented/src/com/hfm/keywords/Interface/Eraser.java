package com.hfm.keywords.Interface;

/**
 * 接口
 * 橡皮擦功能
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
interface Eraser {
    /**
     * 接口的成员变量默认修饰符为 [public] [static] [final] 可以省略不写
     */
    double PI = 3.14;

    /**
     * abstract 方法
     */
    public abstract void remove();

    /**
     * default 方法
     */
    default void rewrite() {
        System.out.println("橡皮擦功能");
    }
}
