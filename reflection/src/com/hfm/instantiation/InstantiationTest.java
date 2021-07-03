package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-26 20:59
 * @Description 类初始化与对象初始化 demo
 * @date 2021/6/26
 */
public class InstantiationTest {
    public static int salary = getSalary();
    static InstantiationTest instantiationTest = new InstantiationTest();

    private static int getSalary() {
        System.out.println(1);
        return 20000;
    }
    static {
        System.out.println(2);
    }

    private int workAge = getWorkAge();

    private int getWorkAge() {
        System.out.println(3);
        return 10;
    }

    {
        System.out.println(4);
    }

    public InstantiationTest() {
        System.out.println(5);
    }

    public static void main(String[] args) {
        System.out.println(6);
        new InstantiationTest();
    }
}
