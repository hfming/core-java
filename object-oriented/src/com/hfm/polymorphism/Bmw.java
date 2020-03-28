package com.hfm.polymorphism;

public class Bmw extends Car implements AirConditioner {
	private double price;
	/**
	 * 父类的构造函数
	 * @param name
	 * @param uuid
	 * @param color
	 */
	public Bmw(String name, String uuid, String color) {
		super(name, uuid, color);
	}
	/**
	 * 继承父类公有属性后，加入自己的公有属性需要加入自己的构造方法
	 * @param name
	 * @param uuid
	 * @param color
	 * @param price
	 */
	public Bmw(String name, String uuid, String color, double price) {
		super(name, uuid, color);
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 重写父类抽象方法
	 */
	@Override
	public void run() {
		System.out.println("BMW");
	}
	/**
	 * 实现接口
	 */
	@Override
	public void cold() {
		System.out.println("降温");
	}
	@Override
	public void hot() {
		System.out.println("加热");
	}
	/**
	 * 与父类同名的静态函数不是重写，多态的情况下使用的是父类的静态成员函数
	 */
	public static void speedUp(){
		System.out.println("子类加速");
	}
	/**
	 * 子类特有的函数
	 */
	public void superSpeedUp() {
		System.out.println("子类特有的加速方法");
	}
}
