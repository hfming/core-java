package com.hfm.pattern.template;
/**
 * 模板设计模式子类
 * @author hfm
 *
 */
public class GetRunningTime extends TemplateDesignPattern {
	@Override
	public void code() {
		Thread thread = new Thread();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
