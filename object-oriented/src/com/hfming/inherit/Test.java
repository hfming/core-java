package com.hfming.inherit;

/**
 * 测试继承
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Test {

	public static void main(String[] args) {
		Student student = new Student("33021779232", "宏伟", "男", 20);

		// 继承父类的公共方法
		student.eat();
		// 继承父类的公共方法
		student.sleep();
		// 继承父类的公共方法
		student.sport();
		// 调用自己的方法
		student.study();

		BasisStudent basisStudent = new BasisStudent("43556656","hfm","男",20);

		J2EEStudent j2EEStudent = new J2EEStudent("33021779232", "宏伟", "男", 20);
	}
}
