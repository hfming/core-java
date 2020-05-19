package com.hfm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-11 15:43
 */
// 指定生命周期
@Retention(RetentionPolicy.RUNTIME)
// 指定修饰的结构
@Target({ElementType.TYPE})
public @interface PropertiesAnnotation {
    /**
     * 获取类名
     *
     * @return
     */
    String className();

    /**
     * 获取方法名
     *
     * @return
     */
    String menthodName();
}
