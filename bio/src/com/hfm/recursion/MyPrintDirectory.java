package com.hfm.recursion;

import java.io.File;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 逐层打印文件夹及文件名
 * @date 2020-05-03 8:49
 */
public class MyPrintDirectory {
    public static void getFileName(File directory, String space) {
        String str = "|--";
        System.out.println(space + str + directory.getName());

        // 找到文件夹中 的所有子文件与子目录
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFileName(file, space + "\t");
            }
            if (file.isFile()) {
                System.out.println(space + "\t" + str + file.getName());
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("bio");
        getFileName(file, "");
    }
}
