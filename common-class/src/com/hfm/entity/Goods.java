package com.hfm.entity;

/**
 * @author hfm
 * @version 1.01 2020-04-08 17:55
 * @date 2020/4/8
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(String s, int i) {
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods other = (Goods) o;
            if (this.price > other.price) {
                return 1;
            } else if (this.price < other.price) {
                return -1;
            }
            return 0;
        }
        throw new RuntimeException("输入的数据类型不一致");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
