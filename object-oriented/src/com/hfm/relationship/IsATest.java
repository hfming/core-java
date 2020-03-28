package com.hfm.relationship;

import java.util.Objects;

/**
 * 类与类之间的关系
 * 继承 Demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 19:34
 * @date 2020/3/26
 */
public class IsATest {
    public static void main(String[] args) {
        Dog dog = new Dog("史努比");
        dog.eat();
    }
}

/**
 * 抽象类 amimal
 */
abstract class Amimal {
    private String name;

    public Amimal(String name) {
        this.name = name;
    }

    public Amimal() {
    }

    @Override
    public String toString() {
        return "Amimal{" +
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
        Amimal amimal = (Amimal) o;
        return Objects.equals(name, amimal.name);
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

    public abstract void eat();
}

/**
 * 实体类 Dog
 * 实现 amimal 抽象方法
 */
class Dog extends Amimal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " like eat shit!");
    }
}
