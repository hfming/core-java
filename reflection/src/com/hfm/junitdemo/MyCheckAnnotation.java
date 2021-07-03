package com.hfm.junitdemo;

import java.lang.annotation.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-25 21:55
 * @Description 自定义测试注解
 * @date 2021/6/25
 */
// 子类可基础
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
// 指定修饰的结构
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
// @interface 注解声明
public @interface MyCheckAnnotation {
}