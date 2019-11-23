package com.hfming.inherit;

/**
 * 继承的使用
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public abstract class Animal {
    private String name;
    private String color;

    /**
     * 构造函数
     *
     * @param name
     * @param color
     */
    public Animal(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }

    /**
     * 父类方法
     */
    public void eat() {
        System.out.println("eat");
    }

    /**
     * 公共set与get方法
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void run();
}
