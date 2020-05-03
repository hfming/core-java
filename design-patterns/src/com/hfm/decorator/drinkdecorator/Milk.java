package com.hfm.decorator.drinkdecorator;

import com.hfm.decorator.drink.Drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:11
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        // 调用父类的构造函数
        super(drink);
        super.setDescription("Milk");
        super.setPrice(3);
    }
}
