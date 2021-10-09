package com.hfm.activeness;

import java.io.Serializable;

/**
 * 死锁现象
 *
 * @author hfm
 */
public class DeathThread extends Thread implements Serializable {
    private static final long serialVersionUID = -3529952202024691252L;

    /**
     * 每个人都拥有其他人需要的资源，同时又等待其他人拥有的资源，并且每个人在获得所有需要的资源之前都不会放弃已经拥有的资源。当多个线程完成功能需要同时
     * 获取多个共享资源的时候可能会导致死锁。
     */
    public DeathThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        if ("张三".equals(this.getName())) {
            synchronized ("遥控器") {
                System.out.println(this.getName() + "取走了遥控器，准备取电池");
                synchronized ("电池") {
                    System.out.println(this.getName() + "取到了电池，开着空调爽歪歪的吹着 ！！");
                }
            }
        } else if ("李四".equals(this.getName())) {
            synchronized ("电池") {
                System.out.println(this.getName() + "取走了电池，准备取取遥控器");
                synchronized ("遥控器") {
                    System.out.println(this.getName() + "取走了遥控器，开着空调爽歪歪的吹着 ！！");
                }
            }
        }
    }

    public static void main(String[] args) {
        new DeathThread("张三").start();
        new DeathThread("李四").start();
    }
}
