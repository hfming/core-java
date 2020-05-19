package com.hfm.classloader;


/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
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

        // JDK8 以后启动类加载器无法获取
        ClassLoader classLoader = Object.class.getClassLoader();
        // null
        System.out.println(classLoader);

//        ClassLoader classLoader1 = ClassLoaders.appClassLoader();
//        System.out.println(classLoader1);
//
//        ClassLoader classLoader2 = ClassLoaders.platformClassLoader();
//        System.out.println(classLoader2);
//
//        ClassLoader parent = classLoader2.getParent();
//        System.out.println(parent);
    }
}
