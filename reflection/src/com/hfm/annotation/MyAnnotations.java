package com.hfm.annotation;

import java.lang.annotation.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-11 15:14
 */
@Documented
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
@Inherited
// 指定可修饰的结构范围
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
