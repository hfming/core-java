package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-26 17:11
 * @Description 类的加载顺序
 * @date 2021/6/26
 */
public class StaticInitTest2 {
    public static int salary = getSalary();

    private int workAge = getWorkAge();
    /**
     * 本类静态对象
     * 证明了类在链接完成之后就可以使用，不需要进行初始化就能够使用
     * 静态的还是按照顺序执行，构造静态对象的时候实例化非静态会先执行
     */
    private static StaticInitTest2 staticInitTest2 = new StaticInitTest2();

    static {
        System.out.println(1);
    }

    public StaticInitTest2() {
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
        // 2
        // 5
        // 4
        // 3
        // 1
        // 6
        System.out.println(6);
    }
}
