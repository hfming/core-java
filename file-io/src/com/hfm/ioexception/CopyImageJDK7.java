package com.hfm.ioexception;

import java.io.*;

/**
 * JDK 7 IO 处理方式
 */
public class CopyImageJDK7 {
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
     * JDK 7 IO 流不需要手动关闭
     *
     * @param fileInput
     * @param fileOutput
     */
    private static void copyImageByByteStream(File fileInput, File fileOutput) {
        // 捕获异常
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput)
        ) {
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
        }
    }
}
