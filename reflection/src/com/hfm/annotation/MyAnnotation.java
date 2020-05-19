package com.hfm.annotation;

import java.lang.annotation.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 自定义注解
 * @date 2020-05-11 15:15
 */
// 可重复注解
@Repeatable(MyAnnotations.class)
// 子类可基础
@Inherited
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
// 指定修饰的结构
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.MODULE})
public @interface MyAnnotation {
    // 定义抽象方法 作为注解的属性
    // 要求：
    // 1. 属性的返回值类型有下列取值
    //				* 基本数据类型
    //				* String
    //				* 枚举
    //				* 注解
    //				* 以上类型的数组
    // 2. 定义了属性，在使用时需要给属性赋值
    //				1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
    //				2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
    //				3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
    String value() default "hfm";
}