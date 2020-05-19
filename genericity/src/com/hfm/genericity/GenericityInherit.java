package com.hfm.genericity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 16:59
 */
public class GenericityInherit {
}

class Father<T1, T2> {
}

/**
 * 子类不保留父类的泛型
 * 1)没有类型 擦除
 * 等价于class Son extends Father<Object,Object>{
 */
class Son1 extends Father {
}

/**
 * 2)具体类型
 */
class Son2 extends Father<Integer, String> {
}

/**
 * 子类保留父类的泛型
 * 1)全部保留
 */
class Son3<T1, T2> extends Father<T1, T2> {
}

/**
 * 2)部分保留
 */
class Son4<T2> extends Father<Integer, T2> {
}

class Father2<T1, T2> {
}

/**
 * 子类不保留父类的泛型
 * 1)没有类型 擦除
 * 等价于class Son extends Father<Object,Object>{
 */
class Son21<A, B> extends Father {
}

/**
 * 2)具体类型
 */
class Son22<A, B> extends Father<Integer, String> {
}

/**
 * 子类保留父类的泛型
 * 1)全部保留
 */
class Son23<T1, T2, A, B> extends Father<T1, T2> {
}

/**
 * 2)部分保留
 */
class Son24<T2, A, B> extends Father<Integer, T2> {
}
