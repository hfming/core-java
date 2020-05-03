package com.hfm.collection;

import java.util.HashSet;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-26 15:56
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.setName("CC");
        // 没有删除元素
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}
