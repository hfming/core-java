package com.hfming.polymorphic;
/**
 * 矩形类
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class Rectangle extends MyShape {
	private double length;
	private double wide;
	
	public Rectangle(double length, double wide) {
		super();
		this.length = length;
		this.wide = wide;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWide() {
		return wide;
	}

	public void setWide(double wide) {
		this.wide = wide;
	}
	/**
	 * 子类重写父类抽象方法，获取周长
	 */
	@Override
	public double getPerimeter() {
		return 2*(length+wide);
	}
	/**
	 * 子类重写父类抽象方法，获取面积
	 */
	@Override
	public double getArea() {
		return wide*length;
	}

}
