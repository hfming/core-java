package com.hfm.decorator;

import com.hfm.decorator.drink.Decaf;
import com.hfm.decorator.drink.Drink;
import com.hfm.decorator.drink.LongBlack;
import com.hfm.decorator.drinkdecorator.Chocolate;
import com.hfm.decorator.drinkdecorator.Milk;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:13
 */
public class CoffeeTest {
    public static void main(String[] args) {
        // 只点一个单品
        Drink order = new Decaf();
        System.out.println("order description : " + order.getDescription());
        System.out.println("order price : " + order.cost());
        System.out.println("---------------加了调料的----------------");
        order = new LongBlack();
        order = new Milk(order);
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("order description : " + order.getDescription());
        System.out.println("order price : " + order.cost());
    }
}
