package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-26 21:33
 * @Description
 * @date 2021/6/26
 */
public class Test1 {
    public static int k = 0;
    // 1:j i=0 n=0
    // 2:构造代码块 i=1 n=1
    // 3:t1 i=2 n=2
    // 4:i i=3 n=3
    // 5:静态代码块 i=4 n=99
    public static Test1 test1 = new Test1("t1");
    // 1:j i=0 n=0
    // 2:构造代码块 i=1 n=1
    // 3:t1 i=2 n=2
    // 4:j i=3 n=3
    // 5:构造代码块 i=4 n=4
    // 6:t2 i=5 n=5
    // 7:i i=6 n=6
    // 8:静态代码块 i=7 n=99
    public static Test1 test2 = new Test1("t2");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    static {
        print("静态代码块");
    }

    public Test1(String string) {
        System.out.println((++k) + ":" + string + " i=" + i + " n=" + n);
        ++i;
        ++n;
    }

    {
        print("构造代码块");
    }

    private static int print(String string) {
        System.out.println((++k) + ":" + string + " i=" + i + " n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        // 1:j i=0 n=0
        // 2:构造代码块 i=1 n=1
        // 3:t1 i=2 n=2
        // 4:j i=3 n=3
        // 5:构造代码块 i=4 n=4
        // 6:t2 i=5 n=5
        // 7:i i=6 n=6
        // 8:静态代码块 i=7 n=99
        // 9:j i=8 n=100
        // 10:构造代码块 i=9 n=101
        // 11:init i=10 n=102
        Test1 init = new Test1("init");
    }
}
