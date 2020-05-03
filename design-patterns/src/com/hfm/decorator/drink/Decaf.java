package com.hfm.decorator.drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:05
 */
public class Decaf extends Coffee {
    public Decaf() {
        super.setDescription("Decaf");
        // 3块钱
        super.setPrice(3);
    }
}
