package com.hfm.map.sortedmap.treeMap;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-12 19:15
 * @Description
 * @date 2021/6/12
 */
public class MyTreeMapTest {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();

        myTreeMap.put(12, "asss");
        myTreeMap.put(18, "asss");
        myTreeMap.put(16, "asss");
        myTreeMap.put(13, "asss");
        myTreeMap.put(17, "asss");
        myTreeMap.put(15, "asss");
        myTreeMap.put(14, "asss");

        myTreeMap.put(14, "AAAAAAA");

        System.out.println(myTreeMap.toString());

        System.out.println(myTreeMap.get(18));

        System.out.println(myTreeMap.getSize());

        System.out.println(myTreeMap.remove(13));

        System.out.println(myTreeMap.toString());
    }
}
