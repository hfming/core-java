package com.hfm.pattern.singleclass;

/**
 * 线程安全问题的懒汉单例设计模式
 *
 * @author hfm
 * @version 1.01 2020-03-26 22:14
 * @date 2020/3/26
 */
public class LazySigletonPattens1 {
    /**
     * 2.创建本类私有化静态对象的引用
     */
    private static LazySigletonPattens1 lazySigletonPattens = null;

    /**
     * 1.私有化本类构造方法
     */
    private LazySigletonPattens1() {
    }

    /**
     * 3.创建公共的静态方法，提供访问该对象的公共静态方法并在之前判断其是否为空，如果为空则进行初始化赋值
     */
    public static LazySigletonPattens1 getLazySigletonPattens() {
        if (lazySigletonPattens == null) {
            lazySigletonPattens = new LazySigletonPattens1();
        }
        return lazySigletonPattens;
    }

}
