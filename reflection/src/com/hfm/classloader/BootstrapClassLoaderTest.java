package com.hfm.classloader;


/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 启动类加载器
 * @date 2020-05-13 8:38
 */
public class BootstrapClassLoaderTest {
    public static void main(String[] args) {
        // JDK 7 及以前可以使用 Launcher 启动获取器类加载器
//        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }
//
//        System.out.println("bootstrap classload----------------------");
//        final String s = System.getProperty("sun.boot.class.path");
//        System.out.println(s);
//        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
//        final File[] path = (s == null) ? new File[0] : bootstrapClassPath;
//        for (File f : path) {
//            System.out.println(f);
//        }
//        System.out.println();
//        Launcher launcher = Launcher.getLauncher();
//        System.out.println(launcher.getClass().getClassLoader());

        // JDK 8 之后获取类加载器的方式
        // 自定义类使用系统/应用类加载器进行加载
        ClassLoader classLoader = BootstrapClassLoaderTest.class.getClassLoader();
        // jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
        System.out.println(classLoader);

        // 系统/应用类加载器的父加载器为扩展类加载器 主要加载第三方jar 包
        ClassLoader parent = classLoader.getParent();
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@3d24753a
        System.out.println(parent);

        // 通过扩展类加载器的 getParent方法不能够获取启动类加载器 启动类加载器主要用于加载java 核心类库
        ClassLoader parent1 = parent.getParent();
        // null
        System.out.println(parent1);

        /// 或者通过 java 核心类库中的类获取启动类加载器
        ClassLoader boootstarp = Object.class.getClassLoader();
        System.out.println(boootstarp);
    }
}
