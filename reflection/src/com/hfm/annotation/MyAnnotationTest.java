package com.hfm.annotation;

import java.lang.annotation.*;

/**
 * @author hfm
 * @version 1.01 2020-04-08 20:32
 * @date 2020/4/8
 */
@MyAnnotation(value = "myself1")
// 可重用注解
//@MyAnnotation(value = "myself2")
public class MyAnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("test")
        Class clazz = MyAnnotationTest.class;
        Annotation a = clazz.getAnnotation(MyAnnotation.class);
        MyAnnotation m = (MyAnnotation) a;
        // 注解的属性值，如果有默认值就取默认值
        String value = m.value();
        System.out.println(value);
        System.out.println(m.annotationType());
    }
}
