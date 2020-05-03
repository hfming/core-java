package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-27 17:01
 */
public class StudentDeepClone implements Cloneable {
    private int id;
    private String name;
    private int age;
    private Book book;

    public StudentDeepClone() {
    }

    public StudentDeepClone(int id, String name, int age, Book book) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.book = book;
    }

    /**
     * 深克隆
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentDeepClone studentDeepCloneable = (StudentDeepClone) super.clone();
        // 对StudentDeepClone 内的Object 类变量进行克隆
        studentDeepCloneable.setBook((Book) this.book.clone());
        return studentDeepCloneable;
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
