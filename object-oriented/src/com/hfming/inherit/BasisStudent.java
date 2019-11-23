package com.hfming.inherit;
/**
 * 基础班学生类
 * 继承学生类
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class BasisStudent  extends Student{

	public BasisStudent(String gmsfhm, String name, String sex, int age) {
		super(gmsfhm, name, sex, age);
	}
	
	@Override
	public void study() {
		// TODO Auto-generated method stub
		super.study();
	}
}
