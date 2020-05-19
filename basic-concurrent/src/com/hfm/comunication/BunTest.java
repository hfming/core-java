package com.hfm.comunication;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-07 11:51
 */
public class BunTest {
    public static void main(String[] args) {
        Bun bun = new Bun();
        // 美食家线程启动
        new Thread(new Foodie("荒野猎食者",bun),"荒野猎食者").start();
        // 包子铺线程启动
        new Thread(new BunShop("包子铺1号", bun),"包子铺1号").start();
    }
}
