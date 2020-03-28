package com.hfm.keywords.Abstract;

/**
 * 抽象类的使用
 *
 * @author hfm
 * @version 1.01 2019-10-19
 */
public abstract class Person {
    public abstract String getDescription();

    private String name;

    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
