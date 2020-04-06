package com.hfm.keywords.Interface;

/**
 * @author hfm
 * @version 1.01 2020-04-04 16:08
 * @date 2020/4/4
 */
interface USB {
    public void start();

    public void stop();
}

class Computer {
    public static void show(USB usb) {
        usb.start();
        System.out.println("=========== USB 设备工作 ========");
        usb.stop();
    }
};

class Flash implements USB {
    @Override
    public void start() {
        System.out.println("U盘开始工作。");
    }

    @Override
    public void stop() {
        System.out.println("U盘停止工作。");
    }
};

class Print implements USB {
    @Override
    public void start() {
        System.out.println("打印机开始工作。");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作。");
    }
};

public class InterfaceDemo {
    public static void main(String args[]) {
        Computer.show(new Flash());
        Computer.show(new Print());

        Computer.show(new USB() {
            @Override
            public void start() {
                System.out.println("移动硬盘开始运行");
            }

            @Override
            public void stop() {
                System.out.println("移动硬盘停止运行");
            }
        });
    }
};