package com.hfm.constructor;

import java.lang.reflect.Constructor;

/**
 * 构造函数练习
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class AnimalTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 使用构造函数初始化对象
        Animal2 cat = new Animal2(001, "red", "tomcat");

        System.out.println(cat.getName());
        System.out.println(cat.getColor());
        cat.eat();

        // 没有显示创建构=构造函数编译器会给其创建一个无参构造函数并对属性进行初始化赋值
        Class<Animal1> animalClass = Animal1.class;
        Constructor<?>[] constructors = animalClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }

        // 父类的构造函数不能被子类继承
        // Animal 有2个构造函数，dog 子类只有一个无参构造函数
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors2 = dogClass.getConstructors();
        for (int i = 0; i < constructors2.length; i++) {
            System.out.println(constructors2[i]);
        }
    }
}
