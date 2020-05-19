package com.hfm.genericity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 10:45
 */
public class MyGenericClass<T> {
    /**
     * 没有 T 类型，在这里代表 未知的一种数据类型 未来传递什么就是什么类型
     */
    private T t;

    MyGenericClass(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void showClass(T t) {
        System.out.println(t.getClass());
    }
}
