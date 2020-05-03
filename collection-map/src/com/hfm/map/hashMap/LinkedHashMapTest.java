package com.hfm.map.hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-23 16:15
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        /**
         *     java.util.LinkedHashMap<K,V> entends HashMap<K,V>
         *     Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。
         *     底层原理:
         *         哈希表+链表(记录元素的顺序)
         */
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("c", "c");
        map.put("b", "b");
        map.put("a", "d");
        // key不允许重复,无序 {a=d, b=b, c=c}
        System.out.println(map);

        LinkedHashMap<String, String> linked = new LinkedHashMap<>();
        linked.put("a", "a");
        linked.put("c", "c");
        linked.put("b", "b");
        linked.put("a", "d");
        // key不允许重复,有序 {a=d, c=c, b=b}
        System.out.println(linked);
    }
}
