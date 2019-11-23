package com.hfming.inherit;
/**
 * 人员类实体
 * |所有人员物种的父类
 * |具有姓名，性别，年龄，籍贯，身份证号等公共属性
 * |具有吃饭、睡觉运动等公共行为
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class People {
	/**
	 * 公共属性
	 */
	private String gmsfhm;
	private String name;
	private String sex;
	private int age;
	/**
	 * 构造方法
	 * @param gmsfhm
	 * @param name
	 * @param sex
	 * @param age
	 */
	public People(String gmsfhm, String name, String sex, int age) {
		super();
		this.gmsfhm = gmsfhm;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	/**
	 * 访问器与修改器
	 * @return
	 */
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 公共静态方法
	 */
	public  static void sleep() {
		System.out.println("睡觉");
	}
	public static void eat(){
		System.out.println("吃饭");
	}
	public static  void sport() {
		System.out.println("运动");
	}
	/**
	 * 父类方法
	 */
	 void look() {
		System.out.println("父类方法");
	}
}
