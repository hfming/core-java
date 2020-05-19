package com.hfm.classloader;

import java.io.InputStream;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 获取类加载器
 * @date 2020-05-11 16:56
 */
public class GetClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println(platformClassLoader);

        // 1.获取一个系统类加载器 应用类加载器 AppClassLoader
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        System.out.println(classloader);

        // 2.获取系统类加载器的父类加载器，即扩展类加载器  PlatformClassLoader
        classloader = classloader.getParent();
        System.out.println(classloader);

        // 3.获取扩展类加载器的父类加载器，即引导类加载器 null
        // 引导类加载器主要负责加载 Java 的核心类库，无法加载自定义类
        classloader = classloader.getParent();
        System.out.println(classloader);

        // 4.测试当前类由哪个类加载器进行加载  AppClassLoader
        classloader = Class.forName("com.hfm.classloader.GetClassLoader").getClassLoader();
        System.out.println(classloader);

        // 5.测试JDK提供的Object类由哪个类加载器加载 null
        classloader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classloader);

        // String 类也是 BootStap ClassLoader加载器加载的 null
        System.out.println(String.class.getClassLoader());
        // 6.关于类加载器的一个主要方法：getResourceAsStream(String str):获取类路径下的指定文件的输入流

        InputStream in = GetClassLoader.class.getClassLoader().getResourceAsStream("D:\\Code\\core-java-simple\\reflection\\src\\com\\hfm\\reflection\\pro.properties");
        System.out.println(in);
    }
}
