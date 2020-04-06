package com.hfm.polymorphism;

/**
 * @author hfm
 * @version 1.01 2020-03-30 17:26
 * @date 2020/3/30
 */
public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("键盘开启，绿灯闪一闪");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭，绿灯熄灭");
    }

    /**
     * 私有方法
     */
    public void type() {
        System.out.println("键盘打字");
    }
}
