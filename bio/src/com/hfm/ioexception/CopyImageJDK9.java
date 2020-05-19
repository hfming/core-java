package com.hfm.ioexception;

import java.io.*;

/**
 * JDK 9 IO 处理方式
 */
public class CopyImageJDK9 {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        File fileInput = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        File fileOutput = new File("file-io\\Resources\\test\\test1.0\\test2.0\\P1 File 类的概述.flv");
        fileOutput.delete();
        copyImageByByteStream(fileInput, fileOutput);
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }

    /**
     * JDK 9 自动关闭资源
     * @param fileInput
     * @param fileOutput
     * @throws FileNotFoundException
     */
    private static void copyImageByByteStream(File fileInput, File fileOutput) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileInput);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
        // 捕获异常
        // JDK 9 IO流处理方式
        try (fileInputStream; fileOutputStream) {
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
