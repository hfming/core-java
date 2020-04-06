package com.hfm.polymorphism;

/**
 * USB接口
 *
 * @author hfm
 * @version 1.01 2020-03-30 17:23
 * @date 2020/3/30
 */
public interface USB {
    /**
     * 开启功能
     */
    public abstract void open();

    /**
     * 关闭功能
     */
    void close();
}

