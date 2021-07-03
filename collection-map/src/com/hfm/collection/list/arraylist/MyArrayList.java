package com.hfm.collection.list.arraylist;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 自定义 ArrayList 集合
 * @date 2020-04-29 18:31
 */
public class MyArrayList<E> extends AbstractList<E> {
    public Object add;
    /**
     * 创建底层数组
     */
    private Object[] elementDate;
    /**
     * 元素的个数
     */
    private int size;

    /**
     * 默认创建长度为 0 的数组
     */
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATE = {};
    /**
     * 默认长度
     */
    private static final int DEFAULT_CAPACITY = 10;


    /**
     * 无参构造函数
     */
    MyArrayList() {
        // 默认初始长度为 0
        elementDate = DEFAULT_EMPTY_ELEMENTDATE;
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
    public E remove(int index) {
        checkIndexRange(index);
        E o = get(index);
        System.arraycopy(elementDate, index + 1, elementDate, index, size -1 - index);
        elementDate[--size] = null;
        return o;
    }

    /**
     * 扩容方法
     */
    private void grow() {
        // 第一次添加元素
        if (size == 0) {
            elementDate = new Object[DEFAULT_CAPACITY];
        }
        // 默认扩容0.5倍
        if (size == elementDate.length) {
            int newCaptcity = elementDate.length + elementDate.length >> 1;
            elementDate = Arrays.copyOf(elementDate, newCaptcity);
        }
    }

    @Override
    public E get(int i) {
        // 判断 index 范围
        checkIndexRange(i);
        return (E) elementDate[i];
    }

    @Override
    public E set(int index, E element) {
        checkIndexRange(index);
        E e = get(index);
        return (E) (elementDate[index] = element);
    }

    /**
     * 检查索引范围
     *
     * @param i
     */
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
