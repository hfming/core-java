package com.hfm.collection.list;

import com.hfm.entity.User;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-17 4:55
 */
public class ListAndAbstractListTest {
    @Test
    public void listTest() {
        // List 为接口，不能创建对象，只能创建实现 list 接口的子类
        new List<User>() {
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
            public Iterator<User> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends User> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends User> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public User get(int i) {
                return null;
            }

            @Override
            public User set(int i, User user) {
                return null;
            }

            @Override
            public void add(int i, User user) {

            }

            @Override
            public User remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<User> listIterator() {
                return null;
            }

            @Override
            public ListIterator<User> listIterator(int i) {
                return null;
            }

            @Override
            public List<User> subList(int i, int i1) {
                return null;
            }
        };
        // AbstractList 为抽象类，也不能创建对象，只能创建子类实现抽象方法
        new AbstractList() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Object get(int i) {
                return null;
            }
        };

        /// 添加
        ArrayList<User> users = new ArrayList<User>();
        // Collection 集合的add 方法
        users.add(new User(0001, "hfm", "0001"));
        users.add(new User(0002, "trt", "0002"));
        users.add(new User(0003, "dsd", "0003"));
        System.out.println(users);

        User user = new User(0004, "trt", "0004");

        // add(int index, E element) 指定位置添加元素
        users.add(2, user);
        System.out.println(users);

        ArrayList<User> users2 = new ArrayList<User>();
        users2.add(new User(0005, "yfg", "0005"));

        //  addAll(int index, Collection<? extends E> c) 将指定集合中的所有元素插入到此列表中的指定位置（可选操作）。
        users.addAll(1, users2);
        System.out.println(users);

        /// 删除
        // E remove(int index) 删除指定位置元素
        users.remove(1);
        System.out.println(users.toString());

        // retainAll(Collect ) 只保留该列表中包含在指定集合中的元素(可选操作)。
        users.retainAll(users);
        System.out.println(users.toString());

        ///	修改
        // E set(int index, E element)返回的是需要替换的集合中的元素
        users.set(0, new User(0006, "fsd", "0006"));
        System.out.println(users);

        ///	查找
        users.add(new User(0001, "hfm", "0001"));
        users.add(new User(0002, "trt", "0002"));
        users.add(new User(0003, "dsd", "0003"));

        // E get(int index) 注意： IndexOutOfBoundsException
        System.out.println(users.get(0).toString());
        // 首次出现的位置
        System.out.println(users.indexOf(new User(0002, "trt", "0002")));
        // 最后出现的位置
        System.out.println(users.lastIndexOf(new User(0002, "trt", "0002")));
        // subList(int fromIndex, int toIndex)	返回此列表中指定的 fromIndex（含）和 toIndex之间的视图。

        // 返回的是一个内部实现 list 接口的类
        List<User> subList = users.subList(0, 1);
        System.out.println(subList);

        // 静态方法 创建不可修改列表的便捷方法
        // List.of 与 List.copyof 方法创建的实例具有以下特征：
        // 它们是不可修改的。无法添加、删除或替换元素。调用列表中的任何突变器方法将始终导致引发UnsupportedOperationException。但是，如果包含的元素本身是可变的，则可能导致 List 的内容出现更改。
        // 它们禁止元素。尝试使用元素创建它们会导致 nullnullNullPointerException
        // 如果所有元素都是可序列化的，它们都是可序列化的。
        // 列表中元素的顺序与提供的参数的顺序或提供数组中的元素的顺序相同。
        // 它们是基于价值的。调用方不应对返回的实例的标识进行假设。工厂可以自由地创建新实例或重用现有实例。因此，对这些实例（引用相等性 （）、标识哈希代码和同步）的标识敏感操作不可靠，应避免使用。==
        // 它们在序列化窗体页上指定进行序列化。

        // of() 通过对象创建集合
        List<User> ofUser = List.of(user);
        System.out.println(ofUser);

        // UnsupportedOperationException,它们是不可修改的。无法添加、删除或替换元素。调用列表中的任何突变器方法将始终导致引发UnsupportedOperationException。
        // ofUser.remove(user);

        // copyof() 通过已有集合获取拷贝集合
        List<User> userList = List.copyOf(users);
        System.out.println(userList);

        /// 替换
        /**
         * 此方法等价实现代码如下:
         * final ListIterator<E> li = list.listIterator();
         * while (li.hasNext()) {
         *      li.set(operator.apply(li.next()));
         * }
         * 并不是任何类型都适用所有的函数，如上Integer型的List和String型的List就不能用同样的函数，同时，效果也不相同。
         */
        users.replaceAll(t -> t);
        System.out.println(users);

        /// 迭代器
        // 特有迭代器 listIterator 逆序迭代
        ListIterator iterator = users.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        // 逆序迭代
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous().toString());
        }
    }
}
