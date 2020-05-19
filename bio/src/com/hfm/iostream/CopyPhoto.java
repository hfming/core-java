package com.hfm.iostream;

import java.io.*;

/**
 * 字节流练习
 * 考察 FileInputStream 与 FileOutputStream
 * 字节流拷贝出来的文件是可以正常读取的
 */
public class CopyPhoto {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 找到目标文件
        File inFile = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        File outFile = new File("file-io\\Resources\\P1 File 类的概述.flv");
        // 关闭资源(关闭资源的原则：先开后关，后开先关)
        // JDK 7 资源自动关闭  fileOutputStream.close();fileInputStream.close();
        try (
                // 建立数据通道
                FileInputStream fileInputStream = new FileInputStream(inFile);
                FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        ) {
            // 建立缓冲字节数组，边读边写
            // 缓冲数组的大小要足够大，才能使效率发挥到极致
            byte[] buf = new byte[1024 << 7];
            // 用于记录每次读取的字节个数
            int length = 0;
            while ((length = fileInputStream.read(buf)) != -1) {
                // 读多少写多少
                fileOutputStream.write(buf, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        // 运行时间:45 时间短，效率高
        System.out.println("运行时间:" + (end - start));
    }
}
