package com.hfm.recursion;

import java.io.File;
import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-03 8:42
 */
public class PrintDirectory {
    File f ;
    /**
     * 存每一层是否多个文件或目录，true为有多个文件或目录
     */
    ArrayList<Boolean> arrayList = new ArrayList<>();

    /**
     * 设置要输出的目录路径
     *
     * @param path
     */
    public PrintDirectory(String path) {
        f = new File(path);
    }

    /**
     * 入口
     */
    public void doThings() {
        // 刚开始是单个目录
        arrayList.add(false);
        printFile(f);
    }

    public void printFile(File dirc) {
        // 先打印前面的字符
        printChars(dirc);
        // 是不是个目录？
        if (f.isDirectory()) {
            // 列出子文件
            File[] list = dirc.listFiles();
            // 只有一个子文件
            if (list.length == 1) {
                // false为单个文件或目录
                arrayList.add(false);
                f = list[0];
                printFile(f);
                // 为了省略多余字符
                arrayList.remove(arrayList.size() - 1);
            } else {
                arrayList.add(true);
                for (File file : list) {
                    f = file;
                    if (f == list[list.length - 1]) {
                        // 为了省略多余字符
                        arrayList.set(arrayList.size() - 1, false);
                    }
                    printFile(f);
                }
                // 为了省略多余字符
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    /**
     * 让输出形象一些
     *
     * @param dirc
     */
    public void printChars(File dirc) {
        // 根据集合打印，省略多余的符号
        for (Boolean arr : arrayList) {
            System.out.print("\t");
            // 如果是多个文件或目录
            if (arr) {
                System.out.print("|");
            }
        }
        // 最里面的文件也要|的符号
        if (!arrayList.get(arrayList.size() - 1)) {
            System.out.print("|");
        }
        System.out.print("--");
        System.out.println(dirc.getName());
    }

    public static void main(String[] args) {
        PrintDirectory pd = new PrintDirectory("bio\\");
        pd.doThings();
    }
}
