package com.hfm.decorator.drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:04
 */
public class Coffee extends Drink {
    @Override
    public double cost() {
        //super.getPrice()//这个就是父类的价格(自己什么也没加)
        return getPrice();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + cost();
    }
}
