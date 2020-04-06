package com.hfm.object;

import com.hfm.entity.MyObject;

/**
 * object.toString()方法
 *
 * @author hfm
 * @version 1.01 2020-03-28 20:12
 * @date 2020/3/28
 */
public class ObjectToStringTest {
    public static void main(String[] args) {
        Object o = new Object();
        // 默认输出16位内存地址
        // java.lang.Object@58372a00
        System.out.println(o.toString());

        MyObject myObject = new MyObject("hfm");
        // 子类重写 toString 方法
        // MyObject{name='hfm'}
        System.out.println(myObject.toString());
    }
}
