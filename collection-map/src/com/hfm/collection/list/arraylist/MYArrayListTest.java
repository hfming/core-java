package com.hfm.collection.list.arraylist;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-29 19:09
 */
public class MYArrayListTest {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        System.out.println(myArrayList);

        myArrayList.add(2);
        System.out.println(myArrayList);

        myArrayList.remove(0);
        System.out.println(myArrayList);

        myArrayList.set(0, "2");
        System.out.println(myArrayList);
    }
}
