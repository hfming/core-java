package com.hfm.recursion;

import java.io.File;
import java.io.FileFilter;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description  文件过滤器优化
 * java.io.FileFilter 是一个接口，是File的过滤器。该接口的对象可以传递给File类的 listFiles(FileFilter)作为参数， 接口中只有一个方法。
 * @date 2020-05-03 11:27
 */
public class PrintJavaFileTest {
    public static void main(String[] args) {
        File file = new File("file-io\\");
        printJavaFleTest(file);
    }

    /**
     * 递归调用调用所有Java 文件
     *
     * @param dir
     */
    public static void printJavaFleTest(File dir) {
        // 过滤文件
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
            if (file.isDirectory()){
                printJavaFleTest(file);
            }
        }
        // 拉姆达优化
        File[] files2 = dir.listFiles(file -> file.getName().endsWith(".java") || file.isDirectory());
    }
}