package com.hfm.object;

import com.hfm.entity.MyObject;

/**
 * @author hfm
 * @version 1.01 2020-03-28 20:52
 * @date 2020/3/28
 */
public class ObjectHashCodeTest {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        // 默认不同的对象的 hashcode 不同
        // java.lang.Object@58372a00
        System.out.println(object1);
        // java.lang.Object@4dd8dc3
        System.out.println(object2);

        MyObject myObject1 = new MyObject("aaa");
        MyObject myObject2 = new MyObject("aaa");
        // 子类重写hashcode 方法，使相同内容的对象的hashcode码相同
        // Objects.hash(name)
        System.out.println(myObject1.hashCode());
        // Objects.hash(name)
        System.out.println(myObject2.hashCode());
    }
}
