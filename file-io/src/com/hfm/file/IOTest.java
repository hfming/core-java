package com.hfm.file;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {
        File file = new File("file-io\\Resources\\Test.txt");
        // 获取文件名
        System.out.println(file.getName());
        // JDK 7 自动关闭资源
        try (
                // 字节流
                FileInputStream inputStream = new FileInputStream(file);
                //FileOutputStream  outputStream = new FileOutputStream(file);
                // 字节缓冲流
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                // 字符流
                FileReader fileReader = new FileReader(file);
                //FileWriter fileWriter = new FileWriter(file);
                // 字符缓冲流
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            int length = -1;
            byte[] b = new byte[1024];
            while ((length = bufferedInputStream.read(b)) != -1) {
                // System.out.println(length);
                System.out.println(new String(b, 0, length));
            }
            inputStream.close();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
