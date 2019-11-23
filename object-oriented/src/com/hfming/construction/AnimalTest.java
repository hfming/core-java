package com.hfming.construction;

/**
 * 构造函数练习
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class AnimalTest {
    public static void main(String[] args) {
        // 使用构造函数初始化对象
        Animal cat =  new Animal(001,"red","tomcat");

        System.out.println(cat.getName());
        System.out.println(cat.getColor());
        cat.eat();
    }
}
