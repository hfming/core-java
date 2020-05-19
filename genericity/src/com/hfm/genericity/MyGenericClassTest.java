package com.hfm.genericity;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-30 10:47
 */
public class MyGenericClassTest {
    public static void main(String[] args) {
        MyGenericClass myGenericClass = new MyGenericClass(new String("自定义泛型使用"));
        System.out.println(myGenericClass.getT());
        myGenericClass.setT("自定义泛型");
        System.out.println(myGenericClass.getT());

        myGenericClass = new MyGenericClass(23);
        System.out.println(myGenericClass.getT());

        myGenericClass.showClass(123);
        myGenericClass.showClass("sdsd");
        myGenericClass.showClass(new ArrayList<String>());
    }
}
