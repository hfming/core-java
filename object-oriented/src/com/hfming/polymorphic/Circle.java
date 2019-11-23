package com.hfming.polymorphic;
/**
 * 圆形类，继承父类图形类
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class Circle extends MyShape {
	private double radius;
	private double diameter;
	private final static double PI = 3.14;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getDiameter() {
		return 2*radius;
	}
	/**
	 * 重写父类抽象方法，获取周长
	 */
	@Override
	public double getPerimeter() {
		return 2*radius*PI;
	}
	/**
	 * 重写父类抽象方法，获取面积
	 */
	@Override
	public double getArea() {
		return PI*radius*radius;
	}

}
