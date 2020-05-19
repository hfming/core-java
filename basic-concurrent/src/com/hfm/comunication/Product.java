package com.hfm.comunication;

/**
 * 商品类
 *
 * @author hfm
 */
public class Product {
    private String name;
    private double price;
    /**
     * 产品是否生成完毕的标识 false为还没有生成完毕，true 生成完毕了.
     */
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
