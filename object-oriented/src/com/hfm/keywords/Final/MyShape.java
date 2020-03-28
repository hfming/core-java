package com.hfm.keywords.Final;
/**
 * 创建一个图形类
 * 描述图形、矩形、 圆形三个类,首先要把三者之间的关系描述清楚，
 * 所有的图形都有计算面积以及周长的方法，但是每种图形的计算面积与周长方式并不一致
 * @author hfm
 * @version 1.01 2019-10-17
 */
public abstract class MyShape {
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

	/**
	 * final 修饰的方法不能被重写
	 */
	public final void show(){
		System.out.println("this is a sshape");
	}
}
