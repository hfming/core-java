package com.hfm.decorator.drinkdecorator;

import com.hfm.decorator.drink.Drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 14:08
 */
public class Decorator extends Drink {
    /**
     * 这个引用很重要，可以是单品，也可以是被包装过的类型，所以使用的是超类的对象
     * 这个就是要被包装的单品(被装饰的对象)  //这里要拿到父类的引用，因为要控制另一个分支
     */
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    /**
     * 如果drink是已经被装包过的，那么就会产生递归调用最终到单品
     *
     * @return
     */
    @Override
    public double cost() {
        // 自己的价格和被包装单品的价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + super.getPrice() + "&&" + drink.getDescription();
    }
}
