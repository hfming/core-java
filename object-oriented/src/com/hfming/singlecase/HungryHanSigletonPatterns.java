package com.hfming.singlecase;

/**
 * 饿汉单例设计模式
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class HungryHanSigletonPatterns {
	// 2.创建本类私有的静态对象
	private static  HungryHanSigletonPatterns hungryHanSigletonPatterns = new HungryHanSigletonPatterns();
	// 1.私有化本类构造函数
	private HungryHanSigletonPatterns() {
	}
	// 提供公共的静态方法获取该对象
	public static HungryHanSigletonPatterns getHungryHanSigletonPatterns() {
		return hungryHanSigletonPatterns;
	}
}
