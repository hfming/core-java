package com.hfm.decorator.drinkdecorator;

import com.hfm.decorator.drink.Drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:11
 */
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        super.setDescription("Soy");
        super.setPrice(2);
    }
}
