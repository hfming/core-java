package com.hfm.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description Serializable 学生类
 * @date 2020-04-27 16:06
 */
public class StudentSerializable implements Serializable {
    /**
     * serialVersionUID 版本号
     */
    private static final long serialVersionUID = -819757735752142194L;
    private int id;
    private String name;
    private int age;

    public StudentSerializable() {
    }

    public StudentSerializable(int id, String name, int ag) {
        this.id = id;
        this.name = name;
        this.age = age;
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
