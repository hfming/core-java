package com.hfm.map;

import com.hfm.entity.People;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 遍历 Map 集合
 * @date 2020-04-22 11:42
 */
public class IteratorMapTest {
    /**
     * 对键进行遍历
     */
    @Test
    public void keySetTest() {
        Map<Integer, People> users = new HashMap();
        users.put(1, new People("hfm", 24));
        users.put(2, new People("hfm", 24));
        users.put(3, new People("hfm", 24));
        users.put(1, new People("hfm", 24));
        users.put(1, new People("hfm", 25));
        users.put(1, new People("te", 24));
        System.out.println(users);

        // 总览进行键的遍历
        Set<Integer> keySet = users.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 对值进行遍历
     */
    @Test
    public void valuesTest() {
        Map<Integer, People> users = new HashMap();
        users.put(1, new People("hfm", 24));
        users.put(2, new People("hfm", 24));
        users.put(3, new People("hfm", 24));
        users.put(1, new People("hfm", 24));
        users.put(1, new People("hfm", 25));
        users.put(1, new People("te", 24));
        System.out.println(users);

        // 只能进行值的遍历
        Collection<People> values = users.values();
        Iterator<People> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 对 entry 进行遍历
     */
    @Test
    public void entrySetTest() {
        Map<Integer, People> users = new HashMap();
        users.put(1, new People("1", "hfm", 24));
        users.put(2, new People("2", "hfm", 24));
        users.put(3, new People("3", "hfm", 24));
        users.put(1, new People("1", "hfm", 24));
        users.put(1, new People("1", "hfm", 25));
        users.put(1, new People("1", "te", 24));
        users.put(1, new People("134", "txse", 245));
        System.out.println(users);

        // 可以同时对键与值进行遍历
        Set<Map.Entry<Integer, People>> entries = users.entrySet();
        Iterator<Map.Entry<Integer, People>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(users.get(1));
    }

    /**
     * JDK 1.8 开始具有的方法
     */
    @Test
    public void forEach() {
        Map<Integer, People> users = new HashMap();
        users.put(1, new People("1", "hfm", 24));
        users.put(2, new People("2", "hfm", 24));
        users.put(3, new People("3", "hfm", 24));
        users.put(1, new People("1", "hfm", 24));
        users.put(1, new People("1", "hfm", 25));
        users.put(1, new People("1", "te", 24));
        users.put(1, new People("134", "txse", 245));
        System.out.println(users);

        users.forEach((Integer key, People people) -> {
            System.out.println(key.toString() + people.toString());
        });

        users.forEach((Integer key, People people) -> System.out.println(key.toString() + people.toString()));

        users.forEach((key, people) -> System.out.println(key.toString() + people.toString()));
    }
}
