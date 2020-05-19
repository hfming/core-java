package com.hfm.genericity;

/**
 * 泛型接口实现类
 *
 * @param <T>
 * @author hfm
 */
public class UserDao<T> implements Dao<T> {
    /**
     * 实现泛型接口的泛型方法
     *
     * @param t
     */
    @Override
    public void add(T t) {
    }
}
