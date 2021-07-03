package com.hfm.collection;

import com.hfm.entity.People;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-17 2:36
 */
public class IteratorTest {
    @Test
    public void iterator() {
        // 接口不能创建对象，只能创建实现接口的类对象
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    /**
     * NoSuchElementException：没有找到元素
     */
    @Test
    public void nextTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        System.out.println(iterator.next());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // NoSuchElementException,指针已经移动到末尾，没有下一个元素了
        // 不会返回null,而是会报错
        System.out.println(iterator.next());
    }

    @Test
    public void ForTest() {
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    /**
     * IllegalStateException:非法状态异常
     * 如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException。
     */
    @Test
    public void removeTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        // 运行错误 java.lang.IllegalStateException
        // 必须先 next 在 remove
//        iterator.remove();
        iterator.next();
        iterator.remove();
    }

    /**
     * ConcurrentModificationException：并发修改异常
     */
    @Test
    public void removeTest2() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            System.out.println(next);
            // ConcurrentModificationException,在进行迭代时，只能迭代器对集合元素进行修改，集合本身不能对元素进行修改
            people.remove(next);
        }
    }

    /**
     * ConcurrentModificationException：并发修改异常
     */
    @Test
    public void removeTest3() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            System.out.println(next);
            // ConcurrentModificationException,在进行迭代时，只能迭代器对集合元素进行修改，集合本身不能对元素进行修改
            people.add(next);
        }
    }

    /**
     * ConcurrentModificationException：并发修改异常
     */
    @Test
    public void removeTest4() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            System.out.println(next);
            // ConcurrentModificationException,在进行迭代时，只能迭代器对集合元素进行修改，集合本身不能对元素进行修改
            people.clear();
        }
    }

    /**
     * 当删除的元素为倒数第二个元素时，不会发生并发修改异常。因为在调用hasNext 方法时，光标的值和集合的长度一样，直接返回false，因此不会调用next方法获取集合元素。
     */
    @Test
    public void removeTest5() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            System.out.println(next);
            // 当删除的元素为倒数第二个元素时，不会发生并发修改异常。因为在调用hasNext 方法时，光标的值和集合的长度一样，直接返回false，因此不会调用next方法获取集合元素。
            if (new People("04", "hfm", 26).toString().equals(next.toString())) {
                people.remove(next);
            }
        }
        System.out.println(people);
    }

    /**
     * for循环遍历集合
     */
    @Test
    public void forTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }

    /**
     * Iterator 迭代器遍历集合
     */
    @Test
    public void iteratorTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        Iterator<People> iterator = people.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(people);
    }

    /**
     * forEach 循环遍历集合
     */
    @Test
    public void foreachTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        // people.iter 快捷键
        for (People person : people) {
            System.out.println(person);
        }
    }

    /**
     * JDK 1.8 新加 forEachRemaining方法遍历集合
     */
    @Test
    public void forEachRemainingTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        people.iterator().forEachRemaining((People person) -> {
            System.out.println(person + "forEachRemaining");
        });
        people.iterator().forEachRemaining(person -> System.out.println(person));
    }

    /**
     * 聚合操作遍历集合
     * Stream API
     */
    @Test
    public void aggregateOperationsTest() {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("01", "hfm", 26));
        people.add(new People("02", "hfm", 26));
        people.add(new People("03", "hfm", 26));
        people.add(new People("04", "hfm", 26));
        people.add(new People("05", "hfm", 26));
        System.out.println(people);

        people.stream().forEach((People person) -> {
            System.out.println(person);
        });

        people.stream().forEach(new Consumer<People>() {
            @Override
            public void accept(People person) {
                System.out.println(person);
            }
        });
        people.stream().forEach(person -> System.out.println(person));
    }
}
