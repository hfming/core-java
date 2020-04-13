package com.hfm.object;

import com.hfm.entity.People;

/**
 * Object 类的方法
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class ObjectTest {
    public static void main(String[] args) {
        // 创建一个Object 对象
        Object object = new Object();
        // toString()方法默认输出内存地址  java.lang.Object@2d98a335
        System.out.println( object.toString());

        // 子类重写toString()方法 NewObject{}
        People people = new People("hfm","23");
        System.out.println(people.toString());

        // Object.equals()
        Object object1 = new Object();
        Object object2 = new Object();
        // 默认比较内存地址
        System.out.println(object1.equals(object2));

        People people1 = new People("hfm","23");
        People people2 = new People("hfm","23");
        // 比较内容
        System.out.println(people1.equals(people2));

        // Object.hashCode()
        // 默认返回hashCode 不同对象不同
        System.out.println(object.hashCode());
        System.out.println(object2.hashCode());

        // Objects.hash(name, age) 不同对象内容相同hashCode相同
        System.out.println(people1.hashCode());
        System.out.println(people2.hashCode());
    }
}
