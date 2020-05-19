package com.hfm.genericity;

/**
 * 泛型接口
 *
 * @param <T>
 * @author hfm
 */
public interface Dao<T> {
    /**
     * 自定义泛型接口
     *
     * @param t
     */
    void add(T t);
}
