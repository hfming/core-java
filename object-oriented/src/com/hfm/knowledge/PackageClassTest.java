package com.hfm.knowledge;

import java.util.ArrayList;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-05-31 17:25
 * @Description 包装类
 * @date 2021/5/31
 */
public class PackageClassTest {
    public static void main(String[] args) {
        String str = "12";
        // 功能一：可以把字符串转成数字
        int num = Integer.parseInt(str);
        System.out.println(num + 1);
        // 功能2： 可以把数字转成指定进制格式的字符串。
        int num2 = 10;
        System.out.println("二进制：" + Integer.toBinaryString(num2));
        System.out.println("八进制：" + Integer.toOctalString(num2));
        System.out.println("十六进制：" + Integer.toHexString(num2));
        // 自动装箱 -->自动把基本数据类型转成引用数据类型数据，
        ArrayList<Integer> list = new ArrayList<Integer>();
        // new Integer(数据)
        list.add(1);
        list.add(2);
        // 自动拆箱： 自动把引用数据类型数据转成 基本数据类型.
        // 引用数据类型数据
        Integer i = new Integer(10);
        // intValue() 获取基本类型的数据
        System.out.println(2 + i);
        /*
         * Integer类内部维护了一个静态的数组，该数组内部存储了-128~127这些数据，当我们创建
         * 一个Integer对象的时候，如果数据是落入到了-128~127这个范围之内，那么会直接从数组中获取，而不会创建新的Integer对象。
         * --> 把一些常用的数据事先创建好，然后贡献给大家一起使用 ： 享元模式。
         */
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println("是同一个对象 吗？" + (i1==i2));

        Integer i7 = 1277;
        Integer i8 = 1277;
        System.out.println("是同一个对象 吗？" + (i7 == i8));

        Integer i3 = new Integer(127);
        Integer i4 = new Integer(127);
        System.out.println("是同一个对象 吗？" + (i3==i4));

        Integer i5 = new Integer(1299);
        Integer i6 = new Integer(1299);
        System.out.println("是同一个对象 吗？" + (i5==i6));
    }
}
