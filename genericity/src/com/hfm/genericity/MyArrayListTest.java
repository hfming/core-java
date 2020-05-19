package com.hfm.genericity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 泛型类的使用
 * @date 2020-04-30 10:05
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        // 创建泛型类
        MyArraysList myArraysList = new MyArraysList();

        Integer[] arr = {3, 4, 6, 7, 74, 2, 3, 5};
        // 调用泛型方法
        myArraysList.reverse(arr);
        for (Integer integer : arr) {
            System.out.print(integer);
        }

        System.out.println("-------------------------");

        String[] strs = {"23", "sdds", "ssdsd", "fiefh"};
        // 调用泛型方法
        myArraysList.reverse(strs);
        for (String str : strs) {
            System.out.print(str);
        }

        printList();
        Object[] ao = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(ao, co);
        String[] sa = new String[20];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);
        Collection<Double> cd = new ArrayList<>();
        // 下面代码中T是Double类，但sa是String类型，编译错误。
        // fromArrayToCollection(sa, cd);
        // 下面代码中T是Object类型，sa是String类型，可以赋值成功。
        fromArrayToCollection(sa, co);

        Collection<?> c = new ArrayList<String>();
        // 唯一 的例外的是null ，它是所有类型的成员。
        c.add(null);
        // 因为我们不知道c的元素类型，我们不能向其中添加对象。add方法有类型参数E作为集合的元素类型。我们传给add的任何参数都必须是一个未知类型的子类。因为我们不知道那是什么类型，所以我们无法传任何东西进去。
        // c.add("string");
        // 另一方面，我们可以调用get() 方法并使用其返回值。返回值是一个未知的类型，但是我们知道，它总是一个 个Object。
        Class<? extends Collection> aClass = c.getClass();
        System.out.println(aClass.getName());
    }

    /**
     * 自定义泛型方法
     *
     * @param list 集合
     * @param <T>  泛型声明
     */
    public static <T> void printList(ArrayList<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    public static <T> void printList() {
        System.out.println("泛型方法");
    }

    public <T> void printList2() {
        System.out.println("泛型方法");
    }

    /**
     * 泛型可变参数的定义
     *
     * @param t
     * @param <T>
     */
    public <T> void printArr(T... t) {
        for (T t1 : t) {
            System.out.println(t1);
        }
    }

    public static void print(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }
}
