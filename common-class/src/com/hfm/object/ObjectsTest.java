package com.hfm.object;

import java.util.Objects;

/**
 * @author hfm
 * @version 1.01 2020-03-30 22:07
 * @date 2020/3/30
 */
public class ObjectsTest {
    public static void main(String[] args) {
        String s1 = "abc";
        //String s1 = null;
        String s2 = "abc";
        //boolean b = s1.equals(s2); // NullPointerException null是不能调用方法的,会抛出空指针异常
        //System.out.println(b);

        //Objects类的equals方法:对两个对象进行比较,防止空指针异常
        // public static boolean equals(Object a, Object b) {
        //     return (a == b) || (a != null && a.equals(b));
        // }
        boolean b2 = Objects.equals(s1, s2);
        System.out.println(b2);
    }
}
