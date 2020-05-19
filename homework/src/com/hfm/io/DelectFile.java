package com.hfm.io;

import java.io.File;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 删除一个非空的目录。
 * @date 2020-05-06 16:55
 */
public class DelectFile {
    private static void deleteFile(File file) {
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
}
