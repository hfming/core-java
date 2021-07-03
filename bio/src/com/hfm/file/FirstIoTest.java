package com.hfm.file;

import java.io.*;

/**
 * 使用 IO 流读取文件演示
 */
public class FirstIoTest {
    public static void main(String[] args) {
        File file = new File("bio\\Resources\\txt\\Test.txt");
        // 获取文件名
        System.out.println(file.getName());
        // JDK 7 自动关闭资源
        try (
                // 字节流
                FileInputStream inputStream = new FileInputStream(file);
                FileOutputStream  outputStream = new FileOutputStream(file);
                // 字节缓冲流
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                // 字符流
                FileReader fileReader = new FileReader(file);
                FileWriter fileWriter = new FileWriter(file);
                // 字符缓冲流
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            // 字节流
            int length;
            byte[] b = new byte[2 << 10 << 8];
            while ((length = bufferedInputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, length));
                // 写出数据
                outputStream.write(b, 0, length);
            }

            // 字节缓冲流
            while ((length = bufferedInputStream.read()) != -1) {
                // 写出数据
                bufferedOutputStream.write(length);
            }

            // 字符流
            char[] chars = new char[2 << 10 << 8];
            while ((length = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, length));
                // 写出数据
                fileWriter.write(chars, 0, length);
            }

            // 字符流缓冲流
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                // 写出数据
                bufferedWriter.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
