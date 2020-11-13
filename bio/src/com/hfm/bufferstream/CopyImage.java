package com.hfm.bufferstream;

import java.io.*;

public class CopyImage {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File fileInput = new File("file-io\\Resources\\video\\P1 File 类的概述.flv");
        File fileOutput = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        copyImageByByteStream(fileInput, fileOutput);
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }

    private static void copyImageByByteStream(File fileInput, File fileOutput) {
        // JDK 7 自动关闭资源
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                // 缓冲输入流
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 1024 << 7);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
                // 缓冲输出流
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024 << 7)
        ) {
            // 记录读取的字节个数
            int length = 0;
            while ((length = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(length);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
