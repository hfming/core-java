package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 浅克隆类
 * @date 2020-04-27 17:13
 */
public class StudentShallowClone implements Cloneable {
    private int id;
    private String name;
    private int age;
    private Book book;

    public StudentShallowClone() {
    }

    public StudentShallowClone(int id, String name, int age, Book book) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.book = book;
    }

    /**
     * 浅克隆
     *
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
        if (!(o instanceof StudentDeepClone)) {
            return false;
        }
        StudentDeepClone that = (StudentDeepClone) o;
        return getId() == that.getId() &&
                getAge() == that.getAge() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getBook(), that.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getBook());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return new StringBuilder("StudentNoCloneable{id=").append(id)
                .append("\',name=").append(name)
                .append("\',age=").append(age)
                .append("\',book=").append(book)
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
