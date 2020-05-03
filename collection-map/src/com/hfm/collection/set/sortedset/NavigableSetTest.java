package com.hfm.collection.set.sortedset;

import org.junit.jupiter.api.Test;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-20 20:34
 */
public class NavigableSetTest {
    @Test
    public void navigableSetTest() {
        NavigableSet navigableSet = new TreeSet();
        navigableSet.add("A");
        navigableSet.add("B");
        navigableSet.add("C");
        navigableSet.add("D");
        navigableSet.add("E");

        System.out.println(navigableSet);
        //  返回该集合中最大的元素严格小于给定的元素，如果没有这样的元素，则返回null。
        System.out.println(navigableSet.lower("D"));
        // 返回该集合中最大的元素小于或等于给定的元素，如果没有这样的元素，返回null。
        System.out.println(navigableSet.floor("D"));
        // 返回此集合中最小元素大于或等于给定元素，如果没有此元素，则返回null。
        System.out.println("B");
        // 返回严格大于给定元素的此集合中的最小元素，如果没有此元素则返回null。
        System.out.println("D");
        // 检索并删除第一个（最低）元素，如果此集合为空，则返回null。
        navigableSet.pollFirst();
        System.out.println(navigableSet);
        // 检索并删除最后一个（最高）元素，如果此集合为空，则返回null。
        navigableSet.pollLast();
        System.out.println(navigableSet);

        // 返回该集合的部分的视图，其元素的范围从fromElement到toElement。
        System.out.println(navigableSet.subSet("B", "E"));
        // 返回元素小于（或等于，包含值为true）toElement的该集合的部分视图
        System.out.println(navigableSet.headSet("E", true));
        System.out.println(navigableSet.headSet("E", false));

        // 返回该集合的元素大于或等于fromElement的部分的视图。
        System.out.println(navigableSet.tailSet("C",true));
        System.out.println(navigableSet.tailSet("C",false));
    }
}
