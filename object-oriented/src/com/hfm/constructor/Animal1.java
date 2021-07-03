package com.hfm.constructor;

/**
 * 需求： 编写 java 类描述一个动物。
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Animal1 {
    private int id;
    private String color;
    private String name;
    // 没有显示创建构造函数

	/**
	 * 公共行为
	 */
	public void eat() {
		System.out.println("动物在吃饭！");
	}

	/**
	 * 公共的get与set方法
	 * @return
	 */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
