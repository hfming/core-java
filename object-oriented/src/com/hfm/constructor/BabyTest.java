package com.hfm.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-05-29 21:01
 * @Description
 * @date 2021/5/29
 */
public class BabyTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // 获取无参构造函数
        Constructor<Baby> constructor2 = Baby.class.getConstructor();
        // 创建对象时构造代码块中的方法也会执行，因此构造代码块会移动到构造函数中执行
        Baby baby2 = constructor2.newInstance(null);
        // 打印内存地址
        System.out.println(baby2);

        // 获取有参构造函数
        Constructor<Baby> constructor = Baby.class.getConstructor(int.class, Date.class);
        // 传入参数创建对象
        // 创建对象时构造代码块中的方法也会执行，因此构造代码块会移动到构造函数中执行
        Baby baby1 = constructor.newInstance(100, new Date());
        // 打印内存地址
        System.out.println(baby1);
    }
}
