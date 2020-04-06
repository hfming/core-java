package com.hfm.object;

import com.hfm.entity.MyObject;

/**
 * @author hfm
 * @version 1.01 2020-03-28 21:55
 * @date 2020/3/28
 */
public class ObjectGetClassTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass());

        MyObject myObject = new MyObject("aaa");
        System.out.println(myObject.getClass());
    }
}
