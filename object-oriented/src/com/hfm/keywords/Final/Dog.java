package com.hfm.keywords.Final;

/**
 * final修饰的类无法继承
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public final class Dog extends Animal {

    /**
     * final修饰的成员变量为常量并使用修改器进行修改
     */
    private static final String NAME = "dog";

    public Dog(String name, String color) {
        super(name, color);
    }

    /**
     * final修饰的方法无法重写
     */
    @Override
    public final void eat() {
        System.out.println("eat");
    }

    @Override
    public void run() {

    }
}
