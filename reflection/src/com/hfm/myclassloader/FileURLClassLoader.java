package com.hfm.myclassloader;

import java.io.File;
import java.net.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-13 12:28
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
