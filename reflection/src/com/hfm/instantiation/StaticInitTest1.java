package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-26 17:11
 * @Description 类的加载顺序
 * @date 2021/6/26
 */
public class StaticInitTest1 {
    public static int salary = getSalary();

    private int workAge = getWorkAge();

    static {
        System.out.println(1);
    }

    public StaticInitTest1() {
        System.out.println(3);
    }

    {
        System.out.println(4);
    }

    private int getWorkAge() {
        System.out.println(5);
        return 10;
    }

    private static int getSalary() {
        System.out.println(2);
        return 20000;
    }

    public static void main(String[] args) {
        // 21 543 543 6
        new StaticInitTest1();
        new StaticInitTest1();
        System.out.println(6);
    }
}
