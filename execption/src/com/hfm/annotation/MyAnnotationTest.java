package com.hfm.annotation;

import java.lang.annotation.*;

/**
 * @author hfm
 * @version 1.01 2020-04-08 20:32
 * @date 2020/4/8
 */
@MyAnnotation(value = "myself")
public class MyAnnotationTest {
    public static void main(String[] args) {
        Class clazz = MyAnnotationTest.class;
        Annotation a = clazz.getAnnotation(MyAnnotation.class);
        MyAnnotation m = (MyAnnotation) a;
        String info = m.value();
        System.out.println(info);
    }
}

/**
 * @author hfm
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
    String value() default "hfm";
}