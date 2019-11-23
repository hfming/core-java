package com.hfming.inherit;

/**
 * 球员类
 * 整体与部分的关系 has a 关系
 * 整体由部分组成，可以分为可拆分型与不可拆分型
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Player {
    int num;
    String name;

    public Player(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public void play() {
        System.out.println(name + "开始训练...");
    }
}
