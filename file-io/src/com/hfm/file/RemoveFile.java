package com.hfm.file;

import java.io.File;
import java.io.IOException;

/**
 * @author hfm
 */
public class RemoveFile {
    public static void main(String[] args) throws IOException {
        File src = new File("c:\\abc");
        File dest = new File("d:\\");
        String all = String.join(" / ", " S ", " M ", " L ", " XL ");
        System.out.println(all);
        cutFile(src, dest);
    }

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

    /**
     * 移动一个非空的目录到另一个地方（剪切）。
     */
    private static void cutFile(File srcDir, File dest) throws IOException {
        if (!srcDir.exists() || !dest.exists()) {
            System.out.println("指定的源目录或者目标目录不存在");
            return;
        }
        if (!srcDir.isDirectory() || !dest.isDirectory()) {
            System.out.println("指定的源目录或者目标目录不是目录");
            return;
        }
        // 得到源目录名
        // abc
        String srcDirName = srcDir.getName();
        // 根据源目录名创建新目录名
        // d:\\abc dest 为父路径
        File destDir = new File(dest + srcDirName);
        // srcDirName 为子路径
        // 创建目标目录
        destDir.mkdir();
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
                cutFile(f, new File(destDir, File.separator));
            }
        }
        // 删除源目录
        srcDir.delete();
    }
}
