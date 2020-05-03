package com.hfm.file;

import java.io.File;

/**
 * @author hfm
 */
public class FilePractice {
    public static void main(String[] args) {
        File dir = new File("file-io\\");
        findJava(dir);
        System.out.println("===================================");
        findClass(dir);
        System.out.println("===================================");
        showAllFiles(dir);
        System.out.println("===================================");
        showAllFiles2(dir);
        System.out.println("===================================");
        findFile(dir, ".txt");
    }

    /**
     * 3.列出指定目录中所有扩展名为.java 的文件。
     *
     * @param dir
     */
    public static void findJava(File dir) {
        // 当前路径下所有文件
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(".java")) {
                    System.out.println(f.getName().toString());
                }
            } else if (f.isDirectory()) {
                // 递归调用
                findJava(f);
            }
        }
    }

    /**
     * 4.列出指定目录中所有扩展名为.class 的文件。
     *
     * @param dir
     */
    public static void findClass(File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                if (files[i].getName().endsWith(".class")) {
                    System.out.println(files[i].getName());
                }
            } else if (files[i].isDirectory()) {
                findClass(files[i]);
            }
        }
    }

    /**
     * 1.列出指定目录中所有的子文件名与所有的子目录名。
     */
    public static void showAllFiles(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.print("子文件：");
                System.out.println(f.getName());
            } else if (f.isDirectory()) {
                System.out.print("子目录");
                System.out.println(f.getName());
                // 递归
                showAllFiles(f);
            }
        }
    }

    /**
     * 2.列出指定目录中所有的子文件名与所有的子目录名，要求目录名与文件名分开列出，格式如下： 子目录： ... ... 子文件： ... ...
     */
    public static void showAllFiles2(File dir) {
        File[] files = dir.listFiles();
        for (File fi : files) {
            //如果是目录
            if (fi.isDirectory()) {
                System.out.println(fi);
                //递归
                showAllFiles2(fi);
            } else {
                //如果是文件
                // 不打印隐藏文件
                if (!fi.isHidden()) {
                    System.out.println(fi);
                }
            }
        }
    }

    /**
     * 5.思考第 3 与第 4 题，代码是不是重复呢，如果想要列出其中的所有.txt 文件，是不是要再写一个类呢？
     */
    public static void findFile(File dir, String name) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(name)) {
                    System.out.println(f.getName().toString());
                }
            } else if (f.isDirectory()) {
                findFile(f, name);
            }
        }
    }
}
