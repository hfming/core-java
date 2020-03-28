package com.hfm.keywords.Instanceof;

/**
 * instanceof
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Rectangle extends MyShape {
    private double length;
    private double weigth;

    /**
     * 构造函数
     *
     * @param length
     * @param weigth
     */
    public Rectangle(double length, double weigth) {
        super();
        this.length = length;
        this.weigth = weigth;
    }

    /**
     * 实现父类获取周长的抽象方法
     */
    @Override
    public double getPerimeter() {
        return 2 * (weigth + length);
    }

    /**
     * 实现父类获取面积的抽象方法
     */
    @Override
    public double getArea() {
        return weigth * length;
    }

    /**
     * 公共set与get方法
	 * @return
     */
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

}
