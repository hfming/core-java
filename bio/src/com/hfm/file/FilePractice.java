package com.hfm.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author hfm
 */
public class FilePractice {
    public static void main(String[] args) throws IOException {
        File dir = new File("bio\\");

//        showAllFiles(dir);

//        ArrayList<String> dirName = new ArrayList<>();
//        ArrayList<String> fileName = new ArrayList<>();
//
//        showAllFiles2(dir, dirName, fileName);
//        System.out.println("子目录：");
//        for (String s : dirName) {
//            System.out.println(s);
//        }
//        System.out.println("子文件：");
//        for (String s : fileName) {
//            System.out.println(s);
//        }

//        findJava(dir);

//        findClass(dir);

//        findFile(dir, ".class");

        cutFile(new File("bio\\Resources\\txt"), new File("bio\\Resources\\text"));
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
    public static void showAllFiles2(File dir, ArrayList<String> dirName, ArrayList<String> fileName) {
        File[] files = dir.listFiles();

        for (File fi : files) {
            //如果是目录
            if (fi.isDirectory()) {
                dirName.add(fi.getName());
                //递归
                showAllFiles2(fi, dirName, fileName);
            } else {
                //如果是文件
                // 不打印隐藏文件
                if (!fi.isHidden()) {
                    fileName.add(fi.getName());
                }
            }
        }
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
                    System.out.println(f.getName());
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
     * 5.思考第 3 与第 4 题，代码是不是重复呢，如果想要列出其中的所有.txt 文件，是不是要再写一个类呢？
     */
    public static void findFile(File dir, String name) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(name)) {
                    System.out.println(f.getName());
                }
            } else if (f.isDirectory()) {
                findFile(f, name);
            }
        }
    }

    /**
     * 删除非空文件夹
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (!file.exists()) {
            System.out.println("路径不存在");
            return;
        }
        if (!file.isDirectory()) {
            System.out.println("不是目录");
            return;
        }
        // 如果当前目录中有子目录和文件,先删除子目录和文件
        File[] listFiles = file.listFiles();
        for (File f : listFiles) {
            if (f.isFile()) {
                f.delete();
            } else if (f.isDirectory()) {
                deleteFile(f);
            }
        }
        // 删除当前目录
        file.delete();
    }

    /**
     * 移动一个非空的目录到另一个地方（剪切）。renameTo 方法
     * * 操作文件：如果源文件与目标文件在同一级路径下，那么renameTo方法的作用是重命名，
     * * 如果源文件与目标文件不在同一级目录下，那么renameTo 的作用就是剪切。
     * * 操作文件夹：如果源文件夹与目标文件夹在同一级路径下，那么renameTo方法的作用是重命名,
     * * 如果源文件夹与目标文件夹不在同一级目录下,那么 renameTo不起作用（不能用于剪切文件夹）。
     */
    private static void cutFile(File srcDir, File dest) throws IOException {
        // 两个目录都存在
        if (!srcDir.exists() || !dest.exists()) {
            System.out.println("指定的源目录或者目标目录不存在");
            return;
        }
        // 两个都是目录
        if (!srcDir.isDirectory() || !dest.isDirectory()) {
            System.out.println("指定的源或者目标不是目录");
            return;
        }
        // 得到源目录名
        String srcDirName = srcDir.getName();
        // 根据源目录名创建新目录名
        File destDir = new File(dest, srcDirName);
        // 创建目标目录
        destDir.mkdirs();
        // 遍历源目录
        File[] listFiles = srcDir.listFiles();
        for (File f : listFiles) {
            // 如果是子源文件,使用renameTo方法,移动至目标目录中(该方法同时会删除源目录中的文件)
            if (f.isFile()) {
                // 指定目标文件的父目录,文件名(根据源文件名生成).
                f.renameTo(new File(destDir, f.getName()));
            } else if (f.isDirectory()) {
                // 如果是子目录,执行重复动作. 将源子目录 , 目标目录(父目录+//)
                // 指定源目录,指定目的路径d:\\abc\\
                cutFile(f, destDir);
            }
        }
        // 删除源目录
        srcDir.delete();
    }
}
