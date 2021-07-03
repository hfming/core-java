package com.hfm.collection.set.hashset;

import com.hfm.entity.Person;
import com.hfm.entity.User;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        /**
         *哈希值:是一个十进制的整数,由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来得到地址,不是数据实际存储的物理地址)
         *     在Object类有一个方法,可以获取对象的哈希值
         *     int hashCode() 返回该对象的哈希码值。
         *     hashCode方法的源码:
         *         public native int hashCode();
         *         native:代表该方法调用的是本地操作系统的方法
         *     自定义对象重写 HashCode 方法会调用 Arrays.hash() 方法计算 hash 码值
         *     public static int hashCode(Object a[]) {
         *         if (a == null){
         *             return 0;
         *         }
         *         int result = 1;
         *         for (Object element : a){
         *             result = 31 * result + (element == null ? 0 : element.hashCode());
         *         }
         *         return result;
         *     }
         */
        //Person类继承了Object类,所以可以使用Object类的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        //1967205423  | 1
        System.out.println(h1);

        Person p2 = new Person();
        int h2 = p2.hashCode();
        //42121758   |  1
        System.out.println(h2);

        /*
         *   toString方法的源码:
         *       return getClass().getName() + "@" + Integer.toHexString(hashCode());
         */
        //com.itheima.demo03.hashCode.Person@75412c2f
        System.out.println(p1);
        //com.itheima.demo03.hashCode.Person@282ba1e
        System.out.println(p2);
        //false
        System.out.println(p1 == p2);

        /*
         String类的哈希值
         String类重写Obejct类的hashCode方法
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        //96354
        System.out.println(s1.hashCode());
        //96354
        System.out.println(s2.hashCode());
        //1179395
        System.out.println("重地".hashCode());
        //1179395
        System.out.println("通话".hashCode());

        HashSet<Person> set = new HashSet<Person>();
        set.add(new Person(110, "来福"));
        // 在现实生活中只要编号一致，则为同一个人。
        set.add(new Person(110, "陈阿福"));
        set.add(new Person(119, "旺财"));
        set.add(new Person(220, "如花"));
        System.out.println("集合的元素：" + set);

        HashSet<User> users = new HashSet<User>();
        users.add(new User(1, "hfm", "1111"));
        users.add(new User(1, "hfm", "1111"));
        users.add(new User(2, "hgm", "1111"));
        users.add(new User(3, "htm", "1112"));
        users.add(new User(4, "hfm", "1111"));
        users.add(new User(4, "aaa", "1111"));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals("hfm")) {
                // 如果这时候改变User的name迭代器的remove方法不能够删除该对象
                // 应为当其名字改变时其存储位置会发生变化
                it.remove();
            }
        }
        System.out.println(users);
    }
}
