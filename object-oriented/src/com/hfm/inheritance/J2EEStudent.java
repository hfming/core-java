package com.hfm.inheritance;
/**
 * java就业班学生
 * 继承自People人员类
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class J2EEStudent extends Student {

	public J2EEStudent(String gmsfhm, String name, String sex, int age) {
		super(gmsfhm, name, sex, age);
	}
	/**
	 * 子类重写父类方法
	 */
	@Override
	public void study() {
		
	}
}
