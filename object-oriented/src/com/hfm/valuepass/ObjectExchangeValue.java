package com.hfm.valuepass;

import java.util.Objects;

/**
 * 引用数据类型值交换
 *
 * @author hfm
 * @version 1.01 2020-03-27 16:13
 * @date 2020/3/27
 */
public class ObjectExchangeValue {
    public static void main(String[] args) {
        Student student1 = new Student("hfm", 26);
        Student student2 = new Student("AOA", 20);
        System.out.println(student1.toString() + "    " + student2.toString());

        objectExchange(student1, student2);
        // 交换失败，仅仅是形参进行交换
        System.out.println(student1.toString() + "    " + student2.toString());

        Student temp = student1;
        student1 = student2;
        student2 = temp;
        // 交换成功，没有形参参与，实参直接进行交换
        System.out.println(student1.toString() + "    " + student2.toString());
    }

    public static void objectExchange(Student student1, Student student2) {
        Student temp = student1;
        student1 = student2;
        student2 = temp;
    }
}

class Student {
    private String name;
    private int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}