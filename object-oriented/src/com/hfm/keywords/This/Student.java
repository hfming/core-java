package com.hfm.keywords.This;

/**
 * 需求：使用 java 类描述一个学生，学生有 name 、age 两个属性， 还具备一个功能就是比较年龄。
 * 要求： 1. 一旦创建了学生对象，学生就有了对应的属性值。 （构造函数、this）
 *
 * @author hfm
 * @version 1.01 2020-03-26 21:53
 * @date 2020/3/26
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 比较年龄
     *
     * @param age
     */
    public void compatorAge(int age) {
        if (age > this.age) {
            System.out.println(this.name + "年龄小！");
        } else {
            System.out.println(this.name + "年龄大！");
        }
    }
}
