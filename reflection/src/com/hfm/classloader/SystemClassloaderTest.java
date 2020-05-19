package com.hfm.classloader;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-13 9:30
 */
public class SystemClassloaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = SystemClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
    }
}
