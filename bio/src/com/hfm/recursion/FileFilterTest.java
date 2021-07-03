package com.hfm.recursion;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 文件过滤器优化
 * java.io.FileFilter 是一个接口，是File的过滤器。该接口的对象可以传递给File类的 listFiles(FileFilter)作为参数， 接口中只有一个方法。
 * @date 2020-05-03 11:27
 */
public class FileFilterTest {
    public static void main(String[] args) {
        File file = new File("bio\\");
        // printJavaFleTest(file);
        printJavaFleTest2(file);
    }

    /**
     * 递归调用调用所有Java 文件
     * FileFilter 过滤器的使用
     *
     * @param dir
     */
    public static void printJavaFleTest(File dir) {
        // FileFilter 过滤文件
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java") || file.isDirectory();
            }
        });
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                printJavaFleTest(file);
            }
        }
        // 拉姆达优化
        dir.listFiles(file -> file.getName().endsWith(".java") || file.isDirectory());
    }

    /**
     * FilenameFilter 过滤器的使用
     *
     * @param dir
     */
    public static void printJavaFleTest2(File dir) {
        // FilenameFilter 过滤器
        // dir- 在中找到文件的目录。
        // name-文件的名称
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith(".java") || file.isDirectory();
            }
        });
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                printJavaFleTest(file);
            }
        }
        // 拉姆达优化
        dir.listFiles((file, name) -> name.endsWith(".java") || file.isDirectory());
    }
}