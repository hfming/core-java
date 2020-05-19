package com.hfm.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 需求：写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执行其中任意方法
 * * 实现：
 * 1. 配置文件
 * 2. 反射
 * * 步骤：
 * 1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 * 2. 在程序中加载读取配置文件
 * 3. 使用反射技术来加载类文件进内存
 * 4. 创建对象
 * 5. 执行方法
 * @date 2020-05-11 14:31
 */
public class RefrectionDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 创建 Properties 对象
        Properties properties = new Properties();

        // 获取应用类加载器 （启动->扩展->应用/系统->自定义）
        ClassLoader classLoader = RefrectionDemo.class.getClassLoader();
        System.out.println(classLoader);
        // 当前路径在 src 下
        InputStream stream = classLoader.getResourceAsStream(".\\com\\hfm\\reflection\\pro.properties");

        // 加载配置文件
        properties.load(stream);

        //2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

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
