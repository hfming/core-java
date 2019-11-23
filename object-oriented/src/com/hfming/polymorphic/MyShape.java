package com.hfming.polymorphic;
/**
 * 需求： 定义了图形、 矩形、 圆形三个类，所有的图形都具备计算面积与周长的方法，只不过每种图形计算方式并不一致。
 * 要求：
 * 		1. 定义一个方法可以接受 任意类型的图形对象，在方法内部调用图形周长与面积的方法。
 * 		2. 定义一个方法可以返回任意类型的图形对象
 * @author hfm
 * @version 1.01 2019-10-16
 */
public abstract class MyShape {
	private double perimeter;
	private double area;
	
	/**
	 * 抽象方法，获取周长
	 * @return
	 */
	public abstract double getPerimeter();
	/**
	 * 抽象方法，获取面积
	 * @return
	 */
	public abstract double getArea();
}
