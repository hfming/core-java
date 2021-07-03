package com.hfm.genericity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 继承情况下的泛型类的定义
 * @date 2020-04-30 16:59
 */

/**
 * 泛型父类
 * @param <T1>
 * @param <T2>
 */
class Father<T1, T2> {
}

/**
 * 子类不保留父类的泛型
 * 1.1.1)没有类型 擦除
 * 默认都是 object
 * 等价于class Son extends Father<Object,Object>{
 */
class Son11 extends Father {
}

/**
 * 1.1.2)具体类型
 */
class Son12 extends Father<Integer, String> {
}

/**
 * 子类保留父类的泛型
 * 1.2.1)全部保留
 */
class Son13<T1, T2> extends Father<T1, T2> {
}

/**
 * 1.2.2)部分保留
 */
class Son14<T2> extends Father<Integer, T2> {
}

/**
 * 子类不保留父类的泛型
 * 2.1.1)没有类型 擦除
 * 等价于class Son extends Father<Object,Object>{
 */
class Son21<A, B> extends Father {
}

/**
 * 2.1.2)具体类型
 */
class Son22<A, B> extends Father<Integer, String> {
}

/**
 * 子类保留父类的泛型
 * 2.2.1)全部保留
 */
class Son23<T1, T2, A, B> extends Father<T1, T2> {
}

/**
 * 2.2.2)部分保留
 */
class Son24<T2, A, B> extends Father<Integer, T2> {
}