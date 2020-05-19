package com.hfm.comunication;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 包子铺
 * @date 2020-05-07 11:43
 */
public class BunShop implements Serializable, Runnable {
    private static final long serialVersionUID = -6380461815975694080L;
    private Bun bun;
    private String name;

    /**
     * 构造函数
     *
     * @param name
     * @param bun
     */
    public BunShop(String name, Bun bun) {
        this.name = name;
        this.bun = bun;
    }

    /**
     * 线程方法
     */
    @Override
    public void run() {
        int count = 0;
        // 一直通知包子做好了
        while (true) {
            //同步
            synchronized (bun) {
                // 包子资源  存在
                if (bun.isFlag() == true) {
                    try {
                        // 等待美食家吃完包子
                        bun.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 没有包子 造包子
                System.out.println("包子铺开始做包子");
                if (count % 2 == 0) {
                    // 冰皮  五仁
                    bun.setPier("冰皮");
                    bun.setXianer("五仁");
                } else {
                    // 薄皮  牛肉大葱
                    bun.setPier("薄皮");
                    bun.setXianer("牛肉大葱");
                }
                count++;
                // 造好包子了
                bun.setFlag(true);
                System.out.println("包子造好了：" + bun.getPier() + bun.getXianer());
                System.out.println("吃货来吃吧");
                //唤醒等待线程（吃货）
                bun.notify();
            }
        }
    }
}
