package com.hfm.instantiation;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-26 21:33
 * @Description
 * @date 2021/6/26
 */
public class AlibabaTest1 {
    public static int k = 0;
    public static AlibabaTest1 test1 = new AlibabaTest1("t1");
    public static int i = print("i");
    public static int n = 99;
    public int j = print("j");

    static {
        print("静态代码块");
    }

    public AlibabaTest1(String string) {
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
        /// t1 对象创建
        // 1:j i=0 n=0
        // 2:构造代码块 i=1 n=1
        // 3:t1 i=2 n=2

        /// 静态代码块、静态初始化语句执行
        // 4:i i=3 n=3
        // 5:静态代码块 i=4 n=99
    }
}
