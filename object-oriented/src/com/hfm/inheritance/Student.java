package com.hfm.inheritance;

/**
 * 学生类继承人父类
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class Student extends People {

    /**
     * 子类继承父类的公共属性，如果没有特有的公共属性并不需要再次写其属性
     */
    public Student(String gmsfhm, String name, String sex, int age) {
        super(gmsfhm, name, sex, age);
    }

    /**
     * 子类继承父类公有的静态方法，如果没有特有的公有行为可以不需要写父类已经有的方法
     */
    public void study() {
        System.out.println("学习");
    }

    /**
     * 继承父类方法
     */
    @Override
    void look() {
        System.out.println("studnt look!");
    }
}
