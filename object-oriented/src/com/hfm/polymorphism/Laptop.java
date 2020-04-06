package com.hfm.polymorphism;

/**
 * @author hfm
 * @version 1.01 2020-03-30 17:27
 * @date 2020/3/30
 */
public class Laptop {
    /**
     * 笔记本开启运行功能
     */
    public void run() {
        System.out.println("笔记本运行");
    }

    /**
     *  笔记本使用usb设备，这时当笔记本对象调用这个功能时，必须给其传递一个符合USB规则的USB设备
     */
    public void useUSB(USB usb) {
        // 判断是否有USB设备
        if (usb != null) {
            usb.open();
            // 类型转换,调用特有方法
            if (usb instanceof Mouse) {
                Mouse m = (Mouse) usb;
                m.click();
            } else if (usb instanceof KeyBoard) {
                KeyBoard kb = (KeyBoard) usb;
                kb.type();
            }
            usb.close();
        }
    }

    public void shutDown() {
        System.out.println("笔记本关闭");
    }
}
