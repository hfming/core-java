package com.hfming.interfacekeywords;

/**
 * 实现接口
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Pencil implements Eraser{

	@Override
	public void remove() {
		System.out.println("铅笔的橡皮擦功能！");
	}
}
