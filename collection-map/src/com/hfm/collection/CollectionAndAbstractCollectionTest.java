package com.hfm.collection;

import com.hfm.entity.People;

import java.util.*;

/**
 * Collection集合方法测试
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class CollectionAndAbstractCollectionTest {
    public static void main(String[] args) {
        // Collection接口为抽象接口，不能创建对象，只能创建实现Collection 接口上的子类
        Collection collection = new Collection() {
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
            public boolean removeAll(Collection collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        // AbstractCollection为抽象类，也不能创建对象，只能创建其子类，子类需要重写 iterator() 与size() 方法
        AbstractCollection abstractCollection = new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
        /// 增加方法
        // 多态的方式，Collection 为接口不能创建对象，只能使用多态的方式将父类引用类型变量指向子类对象
        Collection list = new ArrayList();

        // add() 将指定对象存储到容器中,add方法的参数类型是 Object 便于接收任意对象
        // 添加自定义对象需要重写 equals 方法
        list.add(new People("001", "hfm", 34));

        /// 调用 println(Object) 源码
//        public void println(Object x) {
//            String s = String.valueOf(x);
//            synchronized(this) {
//                this.print(s);
//                this.newLine();
//            }
//        }
//        public static String valueOf(Object obj) {
//            return obj == null ? "null" : obj.toString();
//        }
        // println() 对 boolean、char、int、long、float、double、char[]、String、Object 进行重载，相当与调用 list.toString()
        // 父类 AbstractCollection 对toString 方法进行重写，迭代器遍历打印输出
        System.out.println(list);

        Collection list2 = new ArrayList();
        list2.add(new People("002", "hfm", 54));
        list2.add(new People("003", "hfm", 65));

        // addAll() 将指定集合中的元素添加到调用该方法和集合中
        list.addAll(list2);
        System.out.println(list);

        list2.add(new People("002", "hfm", 54));
        list2.add(new People("003", "hfm", 65));
        People p = new People("004", "hf", 34);
        list2.add(p);
        System.out.println(list2);

        /// 删除方法
        // remove() 将指定的对象从集合中删除
        list2.remove(p);
        System.out.println(list2);

        Collection list3 = new ArrayList();
        list3.add(new People("002", "hfm", 54));
        list3.add(new People("003", "hfm", 65));

        // removeAll() 将指定集合中的元素删除
        // 需要重写 equals 与 hashCode 方法才能根据内容删除
        list2.removeAll(list3);
        System.out.println("list"+list2);

        /// 修改方法
        // clean 清除元素
        list2.clear();
        System.out.println(list2);
        // false 仅仅清空集合里面的元素，引用类型变量还是有地址值
        System.out.println(list2 == null);

        // retainAll() 仅保留此集合中包含的指定集合中的元素（可选操作）。求交集
        System.out.println(list);
        System.out.println(list3);
        list.retainAll(list3);
        System.out.println("retainAll() " + list);

        /// 判断方法
        // isEmpty() 判断集合是否为空
        System.out.println(list2.isEmpty());

        // contains() 判断集合何中是否包含指定对象(底层是依赖了equals方法进行对比的，默认比较内存地址，需要重写equals与hashCode方法)
        System.out.println(list3.contains(p));

        // containsAll() 判断集合中是否包含指定集合
        System.out.println(list.containsAll(list3));

        // 使用equals()判断两个对象是否相等判断，比较集合中的元素是否相同，不是比较内存地址
        System.out.println(list.equals(list3));

        /// 获取方法
        // int size() 返回集合容器的大小
        System.out.println(list.size());
        System.out.println(list2.size());

        // hashCode 返回此集合的哈希代码值。Object.hashCode() 方法默认返回十进制的虚拟地址
        System.out.println(list.hashCode());

        /// 转化为数组
        // toArray() 集合转换数组
        Collection collection1 = new ArrayList();
        collection1.add(1);
        collection1.add(2);
        collection1.add(3);
        collection1.add(4);
        collection1.add(5);

        Object[] arr = collection1.toArray();
        System.out.println(Arrays.toString(arr));

        // toArray(T[] a) 返回包含此集合中所有元素的数组; 返回的数组的运行时类型是指定数组的运行时类型。
        People[] peoples = new People[]{};
        Object[] objects = list.toArray(peoples);
        System.out.println("objects"+Arrays.toString(objects));

        /**
         * 迭代器：iterator()
         * *迭代器常用的方法：
         * ** hasNext() 有没有元素可遍历啊？
         * ** next() 获取当前游标指向的元素，然后游标向下移动一个单位。
         * ** remove() 移除迭代器最后一次返回的元素。
         */
        // iterator()
        Iterator it = list.iterator();
        // 	hasNext() 有没有元素可遍历啊？
        while (it.hasNext()) {
            // 	next() 获取当前游标指向的元素，然后游标向下移动一个单位。
            System.out.println(it.next().toString() + "iterator");
            it.remove();
        }

        System.out.println("===================");
        list.add(new People("002", "hfm", 54));
        list.add(new People("003", "hfm", 65));
        System.out.println(list);

        /**
         * for-each 循环
         */
        for (Object o : list) {
            System.out.println(o + "for each");
        }

        list.forEach(System.out::println);

        // Aggregate Operations 聚合操作在 JDK 8 以后，推荐使用聚合操作对一个集合进行操作。
        // stream() 返回以此集合作为源的顺序 Stream 。
        list.stream().forEach((Object person) -> {
            System.out.println(person + "Aggregate Operations");
        });

        list.stream().forEach(person -> System.out.println(person.toString()));
        // spliterator() 创建一个Spliterator在这个集合中的元素。

        //  forEachRemaining 遍历
        list.iterator().forEachRemaining(people -> System.out.println(people.toString() + "forEachRemaining"));
    }
}
