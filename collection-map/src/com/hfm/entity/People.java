package com.hfm.entity;

import java.util.Objects;

/**
 * 集合操作实体类
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class People implements Comparable {
    /**
     * id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    /**
     * 无参构造函数
     */
    public People() {
        super();
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     */
    public People(String id, String name, int age) {
        this();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 重写 toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 重写 equals
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof People)) {
            return false;
        }
        People people = (People) o;
        return getAge() == people.getAge() &&
                Objects.equals(getId(), people.getId()) &&
                Objects.equals(getName(), people.getName());
    }

    /**
     * 重写 hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

    /**
     * 公共get 与Set方法
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public int compareTo(Object o) {
        if (o instanceof People) {
            People people = (People) o;
            if (this.hashCode() > people.hashCode()) {
                return 1;
            } else if (this.hashCode() > people.hashCode()) {
                return 0;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
