package com.hfm.annotation;

import java.lang.annotation.*;

/**
 * @author hfm
 * @version 1.01 2020-04-08 20:32
 * @date 2020/4/8
 */
@MyAnnotation(value = "myself1")
@MyAnnotation(value = "myself2")
public class MyAnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("test")
        Class clazz = MyAnnotationTest.class;
//        Annotation a = clazz.getAnnotation(MyAnnotation.class);
        MyAnnotation[] annotations =(MyAnnotation[]) clazz.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            System.out.println(annotation.value());
        }
//        MyAnnotation m = (MyAnnotation) a;
//        String info = m.value();
//        System.out.println(info);
    }
}

/**
 * @author hfm
 */
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
@Inherited
// 指定可修饰的结构范围
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
@interface MyAnnotations {
    MyAnnotation[] value();
}

/**
 * @author hfm
 */
// 可重复注解
@Repeatable(MyAnnotations.class)
// 子类可基础
@Inherited
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
// 指定修饰的结构
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
@interface MyAnnotation {
    String value() default "hfm";
}
