package com.hfm.collection;

import java.util.Iterator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-17 4:37
 */
public class ItertableTest {
    public static void main(String[] args) {
        // Collection 父接口，不能创建对象，只能创建实现接口的对象
        Iterable iterable = new Iterable() {
            @Override
            public Iterator iterator() {
                return null;
            }
        };
    }
}
