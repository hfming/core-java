package com.hfm.ioexception;

import java.io.*;

/**
 * JDK 7 以前IO处理方式
 */
public class CopyImageJDK6 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File fileInput = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        File fileOutput = new File("file-io\\Resources\\P1 File 类的概述.flv");
        fileOutput.delete();
        copyImageByByteStream(fileInput, fileOutput);
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }

    /**
     * JDK 1.6 需要手动关闭资源
     *
     * @param fileInput
     * @param fileOutput
     */
    private static void copyImageByByteStream(File fileInput, File fileOutput) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        // 捕获异常
        try {
            fileInputStream = new FileInputStream(fileInput);
            fileOutputStream = new FileOutputStream(fileOutput);
            int length = 0;
            byte[] b = new byte[1024 << 7];
            while ((length = fileInputStream.read(b)) != -1) {
                fileOutputStream.write(b, 0, length);
                // flush() 强制将缓冲数组中的数据写出
                fileOutputStream.flush();
            }
        } catch (FileNotFoundException e) {
            // 抛出运行时异常，可以不处理
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 先开后关,后开先关
                fileOutputStream.close();
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
}
