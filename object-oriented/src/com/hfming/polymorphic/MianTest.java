package com.hfming.polymorphic;

/**
 * 多态测试
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class MianTest {

	public static void main(String[] args) {
		MyShape shape1 = new Circle(4);
		
	}
	/**
	 * 定义一个方法可以接收MyShape类及其子类，可以返回MyShape及其子类
	 * @param shape
	 * @return
	 */
	public static MyShape getShape(MyShape shape){
		System.out.println(shape.getArea());
		System.out.println(shape.getPerimeter());
		return shape;
	}
}
