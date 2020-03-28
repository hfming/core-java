package com.hfm.collection;

import cn.hfming.entity.People;

import java.util.*;

/**
 * Collection集合方法测试
 *
 * @author hfm
 * @version 1.01 2019-10-18
 */
public class AbstractCollectionTest {

    public static void main(String[] args) {
        // AbstractCollection 需要重写 iterator() 与size() 方法
        Collection collection = new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
        /**
         * 增加：
         * 		add() 将指定对象存储到容器中,add方法的参数类型是 Object 便于接收任意对象
         * 		addAll() 将指定集合中的元素添加到调用该方法和集合中
         */
        // 多态的方式，collection为接口不能创建对象，只能使用多态的方式将父类引用类型变量指向子类对象
        Collection list = new ArrayList();
        list.add(new People("001", "hfm", 34));

        Collection list2 = new ArrayList();
        list2.add(new People("002", "hfm", 54));
        list2.add(new People("003", "hfm", 65));

        // addAll() 将指定集合中的元素添加到调用该方法和集合中
        list.addAll(list2);
        System.out.println(list.toString());
        /**
         * 删除
         * 		remove() 将指定的对象从集合中删除
         * 		removeAll() 将指定集合中的元素删除
         * 		clean：清除元素
         */
        // clean 清除元素
        list2.clear();
        System.out.println(list2.toString());

        list2.add(new People("002", "hfm", 54));
        list2.add(new People("003", "hfm", 65));
        People p = new People("004", "hf", 34);
        list2.add(p);
        System.out.println(list2.toString());

        //remove() 将指定的对象从集合中删除
        list2.remove(p);
        System.out.println(list2.toString());

        Collection list3 = new ArrayList();
        list3.add(new People("002", "hfm", 54));
        list3.add(new People("003", "hfm", 65));

        // removeAll() 将指定集合中的元素删除
        list2.removeAll(list3);
        System.out.println(list2.toString());
        /**
         * 判断
         * 		isEmpty() 判断集合是否为空
         * 		contains() 判断集合何中是否包含指定对象(底层是依赖了equals方法进行对比的，默认比较内存地址，需要重写equals与hashCode方法)
         * 		containsAll() 判断集合中是否包含指定集合
         * 		使用equals()判断两个对象是否相等判断
         */
        // isEmpty() 判断集合是否为空
        System.out.println(list2.isEmpty());
        // contains() 判断集合何中是否包含指定对象(底层是依赖了equals方法进行对比的，默认比较内存地址，需要重写equals与hashCode方法)
        System.out.println(list3.contains(p));
        // containsAll() 判断集合中是否包含指定集合
        System.out.println(list3.containsAll(list2));
        // 使用equals()判断两个对象是否相等判断
        System.out.println(list.equals(list3));
        /**
         * 获取:
         * 		int size() 返回集合容器的大小
         */
        // int size() 返回集合容器的大小
        System.out.println(list.size());
        System.out.println(list2.size());
        /**
         * 	转成数组：
         * 		toArray() 集合转换数组
         */
        // toArray() 集合转换数组
        //People[] peo = (People[]) list3.toArray();
        //System.out.println(Arrays.toString(peo));

        // toArray(T[] a) 返回包含此集合中所有元素的数组; 返回的数组的运行时类型是指定数组的运行时类型。

        /**
         * 迭代器：
         * 		iterator()
         * 迭代器常用的方法：
         * 	hasNext() 有没有元素可遍历啊？
         * 	next() 获取当前游标指向的元素，然后游标向下移动一个单位。
         * 	remove() 移除迭代器最后一次返回的元素。
         */
        // iterator()
        Iterator it = list.iterator();
        // 	hasNext() 有没有元素可遍历啊？
        while (it.hasNext()) {
            // 	next() 获取当前游标指向的元素，然后游标向下移动一个单位。
            System.out.println(it.next().toString() + "iterator");
            it.remove();
        }

        // for-each 循环
        for (Object o : list) {
            System.out.println(o + "for each");
        }
        // Aggregate Operations 聚合操作在 JDK 8 以后，推荐使用聚合操作对一个集合进行操作。

        // retainAll(Collection<?> c)  仅保留此集合中包含在指定集合中的元素（可选操作）。

        // spliterator() 创建一个Spliterator在这个集合中的元素。

        // stream() 返回以此集合作为源的顺序 Stream 。

        // 与hasNext() next() 方法不能共用
        it.forEachRemaining(people -> System.out.println(people.toString() + "forEachRemaining"));
    }
}
