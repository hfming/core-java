package com.hfm.collection.set.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-20 18:28
 */
public class SortedSetTest {
    public static void main(String[] args) {
        // 为 SortedSet 实例化
        SortedSet<String> allSet = new TreeSet<String>();
        // 增加元素
        allSet.add("A");
        // 增加元素
        allSet.add("B");
        // 增加元素
        allSet.add("C");
        // 重复元素，不能加入
        allSet.add("C");
        // 重复元素，不能加入
        allSet.add("C");
        // 增加元素
        allSet.add("D");
        // 增加元素
        allSet.add("E");
        System.out.println(allSet);
        System.out.println("第一个元素：" + allSet.first());
        System.out.println("最后一个元素：" + allSet.last());
        System.out.println("headSet 元素：" + allSet.headSet("C"));
        System.out.println("tailSet 元素：" + allSet.tailSet("C"));
        System.out.println("subSet 元素：" + allSet.subSet("B", "D"));
        SortedSet<String> strings = allSet.subSet("B", "E");
        System.out.println(strings);
    }
}
