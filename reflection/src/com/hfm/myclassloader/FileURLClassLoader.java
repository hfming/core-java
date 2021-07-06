package com.hfm.myclassloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-07-06 21:24
 * @Description
 * @date 2021/7/6
 */
public class FileURLClassLoader extends URLClassLoader {
    /**
     * 构造函数
     *
     * @param urls
     */
    public FileURLClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, IllegalAccessException, InstantiationException {
        // 创建自定义文件类加载器
        File file = new File("\\Code\\core-java-simple\\out\\production\\reflection");
        URI uri = file.toURI();
        URL[] urls = {uri.toURL()};
        FileURLClassLoader loader = new FileURLClassLoader(urls);
        // 使用自定义类加载器加载指定的class文件
        Class<?> object1 = loader.findClass("com.hfm.myclassloader.Student");
        System.out.println(object1.newInstance().toString());
    }
}
