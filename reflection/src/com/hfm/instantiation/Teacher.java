package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-07 12:18
 * @Description
 * @date 2021/7/7
 */
public class Teacher {
    int age = 10;
    {
        age = 20;
    }

    public Teacher() {
    }

    public Teacher(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
    }
}
