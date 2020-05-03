package com.hfm.entity;

public class Poker {
    /**
     * 花色
     */
    String color;
    /**
     * 点数
     */
    String num;

    public Poker(String color, String num) {
        super();
        this.color = color;
        this.num = num;
    }

    @Override
    public String toString() {
        return color + num;
    }
}
