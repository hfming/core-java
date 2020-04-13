package com.hfm.object;

import java.util.ArrayList;

/**
 * 包装类
 *
 * @author hfm
 * @version 1.01 2020-03-27 19:57
 * @date 2020/3/27
 */
public class EnumTest2 {
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
        System.out.println("是同一个对象 吗？" + (i1 = i2));
        System.out.println(Gender.WOMAN.getInfo());
    }
}

/**
 * 枚举类
 */
enum Gender {
    // 枚举对象，枚举对象与对象之间通过逗号隔开
    MAN("男") {
        @Override
        public void speak() {
            System.out.println("是男人");
        }
    },
    WOMAN("女") {
        @Override
        public void speak() {
            System.out.println("是女人");
        }
    };
    /**
     * 成员变量
     */
    private String info;

    /**
     * 构造函数
     */
    private Gender() {
    }

    private Gender(String info) {
        this.info = info;
    }

    /**
     * 成员方法
     */
    public String getInfo() {
        return info;
    }

    public abstract void speak();
}
