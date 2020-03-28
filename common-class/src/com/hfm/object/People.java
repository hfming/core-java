package com.hfm.object;

import java.io.Serializable;
import java.util.Objects;

/**
 * Object 类的方法
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class People extends Object implements Cloneable , Serializable {
    private String name;
    private String age;

    /**
     * 构造函数
     * @param name
     * @param age
     */
    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected People clone() throws CloneNotSupportedException {
        People people = (People) super.clone();

        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        People people = (People) o;
        return Objects.equals(name, people.name) &&
                Objects.equals(age, people.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    /**
     * 公共的get与set方法
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
