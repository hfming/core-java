package com.hfm.decorator.drinkdecorator;

import com.hfm.decorator.drink.Drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:10
 */
public class Chocolate extends Decorator {
    /**
     * 如果父类搞了一个带参数的构造函数，子类必须显示的使用super调用
     * @param drink
     */
    public Chocolate(Drink drink) {
        super(drink);
        super.setDescription("Chocolate");
        super.setPrice(1);
    }
}
