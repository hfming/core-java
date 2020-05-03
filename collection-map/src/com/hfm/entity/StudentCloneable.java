package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-27 16:43
 */
public class StudentCloneable implements Cloneable {
    private int id;
    private String name;
    private int age;

    public StudentCloneable() {
    }

    public StudentCloneable(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 重写 clone 方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentSerializable)) {
            return false;
        }
        StudentSerializable that = (StudentSerializable) o;
        return getId() == that.getId() &&
                getAge() == that.getAge() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

    @Override
    public String toString() {
        return new StringBuilder("StudentNoCloneable{id=").append(id)
                .append("\',name=").append(name)
                .append("\',age=").append(age)
                .append("}").toString();
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
}
