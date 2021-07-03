package com.hfm.myclassloader;

import com.hfm.reflect.Person;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description URLClassLoader 测试
 * @date 2020-05-13 11:44
 */
public class UrlClassLoaderTest {
    /**
     * 加载磁盘中的类
     */
    public void fileLoad() {
        try {
            // 1.创建文件
            File file = new File("reflection\\bug.txt");
            // 2.转化为 uri
            URI uri = file.toURI();
            // 3.转为为url
            URL url = uri.toURL();

            // 4.获取类加载器
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
            System.out.println(urlClassLoader);

            System.out.println(urlClassLoader.getParent());
            // 获取类对象
            Class<Person> aClass = (Class<Person>) urlClassLoader.loadClass("com.hfm.reflect.Person");
            // 创建对象
            Person person = aClass.newInstance();
            System.out.println(person);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载网络中的类
     */
    public void urlLoad() {
        try {
            URL url = new URL("www.hfming.com/example");
            // 4.获取类加载器
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
            System.out.println(urlClassLoader);

            System.out.println(urlClassLoader.getParent());
            // 获取类对象
            Class<Person> aClass = (Class<Person>) urlClassLoader.loadClass("com.hfm.reflect.Person");
            // 创建对象
            Person person = aClass.newInstance();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
