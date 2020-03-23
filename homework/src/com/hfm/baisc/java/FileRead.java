package com.hfm.baisc.java;

import java.io.*;

/**
 * 练习 读取文件
 *
 * @author hfm
 * @version 1.01 2019-10-14
 */
public class FileRead {
    public static void main(String[] args) {
        // 创建文件对象
        File file = new File("D:\\intelliJIDEAWorkplace\\core-java\\homework\\read.txt");
        // 建立数据的输入通道
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            // 创建缓存数组
            byte[] content = new byte[1024];
            // 循环读取数据

            while ((fileInputStream.read(content)) != -1) {
                // 输出读到的数据
                System.out.println(new String(content, 0, 1024));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
