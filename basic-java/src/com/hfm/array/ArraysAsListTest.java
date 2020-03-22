package com.hfm.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Arrays.asList()方法使用
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class ArraysAsListTest {
    public static void main(String[] args) {
        String[] s = {"java", "word", "hello", "google"};

        // 转换成固定长度的集合
        // 返回的是 Arrays 内部的 ArrayList 集合,  内部的迭代器没有 Add() , remove() 等功能
        List<String> list = Arrays.asList(s);

        // 获取迭代器
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // 可以使用替换
        list.set(2, "android");

        // java word android google
        for (String st : list) {
            System.out.print(st + " ");
        }
    }
}
