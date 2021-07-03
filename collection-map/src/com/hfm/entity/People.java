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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        People people = (People) o;
        return age == people.age &&
                Objects.equals(id, people.id) &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
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

    /**
     * 通过 id 进行升序，姓名进行升序排序
     *
     * @param o
     * @return Integer
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof People) {
            People people = (People) o;
            if (Integer.parseInt(this.getId()) > Integer.parseInt(people.getId())) {
                return 1;
            } else if (Integer.parseInt(this.getId()) == Integer.parseInt(people.getId())) {
                // TreeSet 中判断元素是否相等，使用 compareTo() 方法返回的值判断，而不是使用 equals 与 hashCode 方法
                // 根据需求可以比较其他属性
                int i = this.getName().compareTo(people.getName());
                if (i > 0) {
                    return 1;
                } else if (i == 0) {
                    return 0;
                } else if (i < 0) {
                    return -1;
                }
                throw new RuntimeException("不能比较");
            } else if (Integer.parseInt(this.getId()) < Integer.parseInt(people.getId())) {
                return -1;
            }
        }
        throw new RuntimeException("不能比较");
    }
}
