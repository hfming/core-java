package com.hfm.recursion;

import java.io.File;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 寻找文件
 * 1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
 * 2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
 * @date 2020-05-03 11:10
 */
public class FindFileTest {
    public static void main(String[] args) {
        File file = new File("file-io\\");
        String tagFileName = "P1 File 类的概述.flv";
        File tagFile = findFile(file, tagFileName);
        // 打印文件路径
        if (tagFile != null) {
            System.out.println(tagFile.getAbsolutePath());
        } else {
            System.out.println("没有找到文件！");
        }
    }

    /**
     * 找到目标文件
     *
     * @param dir
     * @return
     */
    public static File findFile(File dir, String name) {
        File[] files = dir.listFiles();
        for (File file : files) {
            // 是文件，判断文件名并输出文件绝对路径 
            if (file.isFile()) {
                if ( name.equals(file.getName())){
                    return file;
                }
            }
            if (file.isDirectory()) {
                // 是目录，继续遍历,形成递归
               return findFile(file, name);
            }
        }
        return null;
    }
}
