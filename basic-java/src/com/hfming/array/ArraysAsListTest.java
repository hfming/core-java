package com.hfming.array;

import java.util.Arrays;
import java.util.List;
/**
 * Arrays.asList()方法使用
 * @version 1.01 2019-10-02
 * @author hfm
 *
 */
public class ArraysAsListTest {
    public static void main(String[] args) {
        String[] s = { "java", "word", "hello", "google" };
        
        // 转换成固定长度的集合
        List<String> list = Arrays.asList(s);
        // list.add("android"); UnsupportedOperationException不支持该操作
        
        // 可以使用替换
        list.set(2, "android");
        
        // java word android google
        for (String st : list) {
            System.out.print(st + " ");
        }
    }
}
