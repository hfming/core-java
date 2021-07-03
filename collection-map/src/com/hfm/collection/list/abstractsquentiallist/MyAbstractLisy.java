package com.hfm.collection.list.abstractsquentiallist;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 12:12
 * @Description
 * @date 2021/6/11
 */
public abstract class MyAbstractLisy<E> implements MyList<E> {
    /**
     * 链表节点个数
     */
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(E elememt) {
        return indexOf(elememt) != -1;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    int getSize() {
        return size;
    }

    void setSize(int size) {
        this.size = size;
    }
}