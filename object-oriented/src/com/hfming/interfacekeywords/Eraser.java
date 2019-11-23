package com.hfming.interfacekeywords;
/**
 * 接口
 * 橡皮擦功能
 * @author hfm
 * @version 1.01 2019-10-17
 */
interface Eraser {
	/**
	 * abstract 方法
	 */
	public  abstract void remove();

	/**
	 * default 方法
	 */
	default void rewrite() {
		System.out.println("橡皮擦功能");
	}
}
