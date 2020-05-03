package com.hfm.file;

import java.io.File;
import java.io.IOException;

/**
 * @author hfm
 */
public class RemoveFile {
    public static void main(String[] args) throws IOException {
        // 创建文件夹
        File dest = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\test");
        dest.delete();
        // 如果不存在创建此目录
        dest.mkdir();
        System.out.println(dest.getName());

        // 创建文件夹
        File src1 = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\test1.0");
        src1.delete();
        // 如果不存在创建此目录
        src1.mkdir();
        System.out.println(src1.getName());

        // 创建文件夹
        File src2 = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\test1.0\\test2.0");
        src2.delete();
        // 如果不存在创建此目录
        src2.mkdir();
        System.out.println(src2.getName());

        // 创建文件
        File file1 = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\test1.0\\test.txt");
        file1.delete();
        // 如果不存在创建空文件
        file1.createNewFile();
        System.out.println(file1.getName());

        // 创建文件
        File file2 = new File("D:\\Code\\core-java-simple\\file-io\\Resources\\test1.0\\test2.0\\test.txt");
        file2.delete();
        // 如果不存在创建空文件
        file2.createNewFile();
        System.out.println(file2.getName());

//        String all = String.join(" / ", " S ", " M ", " L ", " XL ");
//        System.out.println(all);
        // 剪切非空目录及其下面的所有文件
        cutFile(src1, dest);
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
            System.out.println("指定的源目录或者目标目录不是目录");
            return;
        }
        // 得到源目录名
        String srcDirName = srcDir.getName();
        // 根据源目录名创建新目录名
        File destDir = new File(dest, srcDirName);
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
                cutFile(f, destDir);
            }
        }
        // 删除源目录
        srcDir.delete();
    }
}
