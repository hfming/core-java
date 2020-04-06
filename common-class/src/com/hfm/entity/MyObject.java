package com.hfm.entity;

import java.util.Objects;

/**
 * @author hfm
 * @version 1.01 2020-03-28 20:20
 * @date 2020/3/28
 */
public class MyObject {
    private String name;

    public MyObject() {
    }

    public MyObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
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
        MyObject myObject = (MyObject) o;
        return Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
