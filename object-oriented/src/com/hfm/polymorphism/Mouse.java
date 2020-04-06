package com.hfm.polymorphism;

/**
 * @author hfm
 * @version 1.01 2020-03-30 17:25
 * @date 2020/3/30
 */
public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("鼠标开启，红灯闪一闪");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭，红灯熄灭");
    }

    /**
     * 私有方法
     */
    public void click() {
        System.out.println("鼠标单击");
    }
}
