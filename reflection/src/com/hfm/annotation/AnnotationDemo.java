package com.hfm.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 使用注解替换 配置文件
 * @date 2020-05-11 15:41
 */
@PropertiesAnnotation(className = "java.lang.String", menthodName = "toString")
public class AnnotationDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 创建注解对象 该类的注解对象
        // 先获取该类
        // 再获取该类注解
        // 其实就是再JVM 中生成了一个该类注解的实现类对象
        PropertiesAnnotation annotation = AnnotationDemo.class.getAnnotation(PropertiesAnnotation.class);

        // 使用注解类的实现类对象的方法获取属性值
        String className = annotation.className();
        String methodName = annotation.menthodName();

        //3.加载该类进内存
        Class cls = Class.forName(className);
        System.out.println(cls);

        //4.创建对象
        Constructor constructor = cls.getConstructor(String.class);
        Object object = constructor.newInstance("使用反射创建对象");
        System.out.println(object);

        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法 参数调用方法的对象
        Object invoke = method.invoke(object);
        System.out.println(invoke);
    }
}
