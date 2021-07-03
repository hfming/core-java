package com.hfm.myclassloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 伪代码
 * @date 2020-05-13 11:57
 */
public class SubURLClassLoader extends URLClassLoader {
    private String rootDir;

    public SubURLClassLoader(String rootDir) {
        super(new URL[2]);
        this.rootDir = rootDir;
    }

    /**
     * 编写获取类的字节码并创建class对象的逻辑
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //...省略逻辑代码
//        defineClass()
        return null;
    }

    /**
     * 编写读取字节流的方法
     *
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        //省略代码....
        return null;
    }
}
