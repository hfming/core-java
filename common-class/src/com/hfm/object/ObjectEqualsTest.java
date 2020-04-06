package com.hfm.object;

import com.hfm.entity.MyObject;

/**
 * @author hfm
 * @version 1.01 2020-03-28 20:36
 * @date 2020/3/28
 */
public class ObjectEqualsTest {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        // 默认比较内存地址
        // false
        System.out.println(object1.equals(object2));
        // == 号比较内存地址
        // false
        System.out.println(object1 == object2);

        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        // 子类重写 equals 与 hashcode() 方法，比较对象的内容
        // true
        System.out.println(myObject1.equals(myObject2));
        // == 号比较内存地址
        // false
        System.out.println(myObject1 == myObject2);
    }
}
