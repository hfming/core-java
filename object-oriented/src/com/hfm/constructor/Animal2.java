package com.hfm.constructor;

/**
 * 需求： 编写 java 类描述一个动物。
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Animal2 {
    private int id;
    private String color;
    private String name;

	/**
	 * 无参构造函数
	 */
    public Animal2() {

    }

    /**
     * 有参构造函数
     *
     * @param id
     * @param color
     * @param name
     */
    public Animal2(int id, String color, String name) {
        this.id = id;
        this.color = color;
        this.name = name;
    }

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
