package com.hfm.collection.list.arraylist;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-29 18:31
 */
public class MyArrayList extends AbstractList {
    public Object add;
    /**
     * 创建底层数组
     */
    Object[] elementDate;
    /**
     * 元素的个数
     */
    int size;

    /**
     * 无参
     */
    MyArrayList() {
        // 默认初始长度为 0
        elementDate = new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (size == elementDate.length) {
            grow();
        }
        elementDate[size++] = o;
        ++modCount;
        return true;
    }

    @Override
    public Object remove(int index) {
        Object o = get(index);
        elementDate[index] = null;
        System.arraycopy(elementDate, index + 1, elementDate, index, elementDate.length - index - 1);
        return o;
    }

    private void grow() {
        // 第一次添加元素
        if (size == 0) {
            elementDate = new Object[10];
        }
        // 默认扩容0.5倍
        if (size == elementDate.length) {
            int newCaptcity = elementDate.length + elementDate.length >> 1;
            elementDate = Arrays.copyOf(elementDate, newCaptcity);
        }
    }

    @Override
    public Object get(int i) {
        // 判断 index 范围
        checkIndexRange(i);
        return elementDate[i];
    }

    private void checkIndexRange(int i) {
        if (i < 0 || i > elementDate.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }
}
