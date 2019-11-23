package com.hfming.finalkeywords;

/**
 * final 修饰的类不能被继承
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public final class Circle extends MyShape {
    private double r;
    private double d;
    private static final double PI = 3.14;

    /**
     * 构造函数，给原的半径进行初始化赋值
     *
     * @param r
     */
    public Circle(double r) {
        super();
        this.r = r;
    }

    /**
     * 子类重写父类获取周长的方法
     */
    @Override
    public double getPerimeter() {
        return 2 * PI * r;
    }

    /**
     * @Override 子类重写父类获取面积的方法
     */
    public double getArea() {
        return PI * r * r;
    }

    /**
     * 访问器
     *
     * @return
     */
    public double getR() {
        return r;
    }

    /**
     * 修改器
     *
     * @param r
     */
    public void setR(double r) {
        this.r = r;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

}
