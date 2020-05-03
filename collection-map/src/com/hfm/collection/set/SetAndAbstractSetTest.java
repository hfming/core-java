package com.hfm.collection.set;

import com.hfm.entity.User;
import org.junit.jupiter.api.Test;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-20 15:30
 */
public class SetAndAbstractSetTest {
    @Test
    public void setTest() {
        // 多态方式创建实现接口的实现类
        Set set = new Set() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] objects) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        // 抽象类同样不能创建对象，只能创建实现抽象方法的子类
        AbstractSet abstractSet = new AbstractSet() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
        User user1 = new User(1, "hfm", "1234");
        User user2 = new User(2, "hfm", "1234");
        User user3 = new User(3, "hfm", "1234");
        User user4 = new User(4, "hfm", "1234");

        // 通过Set 的静态方法创建Set集合
        Set<User> users = Set.of(user1, user2, user3, user4);
        System.out.println(users);

        // 通过静态方法拷贝已有Set集合
        Set<User> users1 = Set.copyOf(users);
        System.out.println(users1);
    }
}
