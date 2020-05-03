package com.hfm.map.hashMap;

import com.hfm.entity.People;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-22 17:04
 */
public class HashMapTest {
    @Test
    public void hashMapTest() {
        HashMap<People, String > users = new HashMap();
        users.put(new People("1", "hfm", 24), "1");
        System.out.println(users);
        users.put(new People("1", "hfm", 24), "2");
        System.out.println(users);
        users.put(new People("1", "hfm", 24), "3");
        System.out.println(users);
        // users.put(new People("1", "hfm", 24), "1");
        // System.out.println(users);
        users.put(new People("1", "hfm", 25), "2");
        System.out.println(users);
        users.put(new People("1", "te", 24), "1");
        System.out.println(users);
        users.put(new People("134", "txse", 245), "1");
        System.out.println(users);

        TreeMap<People, Integer> users2 = new TreeMap<>();
        users2.put(new People("1", "hfm", 24), 1);
        //不能存储相同的键
        users2.put(new People("1", "hfm", 24), 2);
        users2.put(new People("1", "hfm", 24), 3);
        users2.put(new People("1", "hfm", 24), 1);
        users2.put(new People("1", "hfm", 25), 2);
        users2.put(new People("1", "te", 24), 1);
        users2.put(new People("134", "txse", 245), 1);
        System.out.println(users2);

        // System.out.println(new People("1", "hfm", 24).hashCode() == new People("1", "hfm", 24).hashCode());

        // 可以同时对键与值进行遍历
        Set<Map.Entry<People, String >> entries = users.entrySet();
        Iterator<Map.Entry<People, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(users.get(new People("134", "txse", 245)));
    }
}
