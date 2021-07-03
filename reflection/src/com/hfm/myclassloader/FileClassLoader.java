package com.hfm.myclassloader;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 自定义文件类加载器
 * 继承 ClassLoader 类实现自定义类加载器需要重写 findClass() 方法
 * @date 2020-05-13 12:22
 */
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    /**
     * 构造函数
     *
     * @param rootDir
     */
    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 编写findClass方法的逻辑
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            // 直接生成class对象
            // 调用父类 defineClass() 方法生成 class 对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     *
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try (
                InputStream ins = new FileInputStream(path);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ){
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead ;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     *
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String rootDir = "D:\\Code\\core-java\\out\\production\\reflection";
        // 创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        // 使用自定义类加载器加载指定的class文件
        // 调用 findClass() 方法会自动调用 ClassLoader 的 defineClass 方法返回 class 对象
        Class clazz = loader.findClass("com.hfm.myclassloader.Student");
        System.out.println(clazz.newInstance().toString());
        test();
    }

    /**
     * 热部署加载器，同一个 class 文件通过不同的类加载器加载两次
     * 直接调用findclass 方法跳过loadClass 方法中的 findLoadedClass 检测
     * @throws ClassNotFoundException
     */
    public static void test() throws ClassNotFoundException {
        String rootDir = "D:\\Code\\core-java\\out\\production\\reflection";
        // 创建自定义文件类加载器
        FileClassLoader loader = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);
        // 加载指定的class文件,调用loadClass()
        Class<?> clazz1 = loader.loadClass("com.hfm.myclassloader.Student");
        Class<?> clazz2 = loader2.loadClass("com.hfm.myclassloader.Student");
        System.out.println("loadClass->obj1:" + clazz1.hashCode());
        System.out.println("loadClass->obj2:" + clazz2.hashCode());

        // 加载指定的class文件,直接调用findClass(),绕过检测机制，创建不同class对象。
        Class<?> object3 = loader.findClass("com.hfm.myclassloader.Student");
        Class<?> object4 = loader2.findClass("com.hfm.myclassloader.Student");
        System.out.println("loadClass->obj3:" + object3.hashCode());
        System.out.println("loadClass->obj4:" + object4.hashCode());
    }
}
