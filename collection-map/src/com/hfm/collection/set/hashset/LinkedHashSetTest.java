package com.hfm.collection.set.hashset;

import com.hfm.entity.Person;
import com.hfm.entity.User;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    @Test
    public void linkedHashSetTest(){
        LinkedHashSet<Person> set = new LinkedHashSet<Person>();
        set.add(new Person(110, "来福"));
        // 在现实生活中只要编号一致，则为同一个人。
        set.add(new Person(110, "陈阿福"));
        set.add(new Person(119, "旺财"));
        set.add(new Person(220, "如花"));
        System.out.println("集合的元素：" + set);

        HashSet<User> users = new HashSet<User>();
        users.add(new User(1, "hfm", "1111"));
        users.add(new User(1, "hfm", "1111"));
        users.add(new User(2, "hgm", "1111"));
        users.add(new User(3, "htm", "1112"));
        users.add(new User(4, "hfm", "1111"));
        users.add(new User(4, "aaa", "1111"));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals("hfm")) {
                // 如果这时候改变User的name迭代器的remove方法不能够删除该对象
                // 应为当其名字改变时其存储位置会发生变化
                it.remove();
            }
        }
        System.out.println(users);
    }
}
