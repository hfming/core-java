package com.hfm.decorator.drink;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description * Component的超类 Drink类
 * * 单品和装饰者都要继承自这个类
 * @date 2020-05-02 14:02
 */
public abstract class Drink {
    /**
     * 一开始没有描述
     */
    private String description = "";
    /**
     * 一开始价格为0
     */
    private double price = 0;

    public String getDescription() {
        return description;
    }

    /**
     * 描述的时候顺便把价格描述一下
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 抽象方法：如果是单品的话就直接是自己的价格；如果是装饰者的话就还要加上装饰品自己的价格
     *
     * @return
     */
    public abstract double cost();
}
