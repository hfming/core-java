package com.hfm.collection.list.abstractsquentiallist;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-11 11:59
 * @Description
 * @date 2021/6/11
 */
public interface MyList<E> {
    /**
     * 获取集合元素个数
     * @return
     */
    int size();

    /**
     * 是否为空元素
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含指定元素
     * @param elememt
     * @return
     */
    boolean contains(E elememt);

    /**
     * 添加元素
     * @param element
     */
    void add(E element);

    /**
     * 获取指定位置上的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 修改指定位置上的元素
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 在指定位置上添加元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 元素首次出现的位置
     * @param element
     * @return
     */
    int indexOf(E element);

    /**
     * 清空集合元素
     */
    void clean();
}
