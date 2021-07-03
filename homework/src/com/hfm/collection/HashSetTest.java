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
        // [Person [id=1001, name=AA, age=null], Person [id=1002, name=BB, age=null]]
        System.out.println(set);
        p1.setName("CC");
        // 没有删除元素，删除的是 CC 存储的位置，然而对象位置还是在 AA
        set.remove(p1);
        // [Person [id=1001, name=CC, age=null], Person [id=1002, name=BB, age=null]]
        System.out.println(set);

        // false ，会重新计算其Hash 码值，但是元素的hash 没有改变
        System.out.println(set.contains(p1));

        // CC 位置没有元素可以添加
        set.add(new Person(1001, "CC"));
        // [Person [id=1001, name=CC, age=null], Person [id=1001, name=CC, age=null], Person [id=1002, name=BB, age=null]]
        System.out.println(set);
        // AA 位置有元素 CC,两个对象内容不同，以链表形式存储
        set.add(new Person(1001, "AA"));
        // [Person [id=1001, name=CC, age=null], Person [id=1001, name=CC, age=null], Person [id=1001, name=AA, age=null], Person [id=1002, name=BB, age=null]]
        System.out.println(set);
    }
}
