package com.hfm.characterstream;

import java.io.*;

public class CharacterStreamTest {
    /**
     * 拷贝文件应该使用字节流，读取文件可以使用字符流
     *
     * @param args
     */
    public static void main(String[] args) {
        File fileInput = new File("file-io\\Resources\\IMG_1.jpg");
        File fileOutput1 = new File("file-io\\Resources\\IMG_2.jpg");
        File fileOutput2 = new File("file-io\\Resources\\IMG_3.jpg");
        File fileOutput3 = new File("file-io\\Resources\\IMG_4.jpg");
        File fileOutput4 = new File("file-io\\Resources\\IMG_5.jpg");
        File fileOutput5 = new File("file-io\\Resources\\IMG_6.jpg");
        File fileOutput6 = new File("file-io\\Resources\\IMG_7.jpg");
        File fileOutput7 = new File("file-io\\Resources\\IMG_8.jpg");
        // 字符流拷贝文件 一个接一个字符读取
        copyImageByCharStream(fileInput, fileOutput1);
        // 自定义缓冲区字符流拷贝文件
        copyImageByMyBufferedCharStream(fileInput, fileOutput2);
        // 缓冲字符流拷贝文件 readLine()
        copyImageByBufferedCharStream(fileInput, fileOutput3);
        // 缓冲字符流拷贝文件 read()
        copyImageByBufferedCharStream2(fileInput, fileOutput4);

        // 字节流拷贝文件
        copyImageByBytesStream(fileInput, fileOutput5);
        // 自定义缓冲区字节流拷贝文件
        copyImageByMyBufferedBytesStream(fileInput, fileOutput6);
        // 使用字节缓冲流拷贝文件
        copyImageByBufferedBytesStream(fileInput, fileOutput7);
    }

    /**
     * 使用字节缓冲流拷贝文件
     *
     * @param fileInput
     * @param fileOutput
     */
    public static void copyImageByBufferedBytesStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 用于存储字节个数
        int num = -1;
        // JDK 7 资源自动关闭
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            while ((num = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(num);
            }
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 自定义缓冲区字节流拷贝文件
     *
     * @param fileInput
     * @param fileOutput
     */
    public static void copyImageByMyBufferedBytesStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 创建字节缓冲区，存储字节数据
        byte[] bytes = new byte[1024 << 7];
        // 记录字节个数
        int num = -1;
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
        ) {
            while ((num = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, num);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 字节流拷贝文件
     *
     * @param fileInput
     * @param fileOutput
     */
    public static void copyImageByBytesStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 记录读取到的字节
        int num = -1;
        // JDK 7 自动关闭资源
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
        ) {
            // 读取字节，一个接一个
            while ((num = fileInputStream.read()) != -1) {
                // 写出字节，一个接一个
                fileOutputStream.write(num);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 字符流拷贝文件 复制的文件不能打开
     *
     * @param
     */
    public static void copyImageByCharStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 存储每次读取到的字符
        int length = -1;
        // JDK 7 自动关闭资源
        try (
                FileReader fileReader = new FileReader(fileInput);
                FileWriter fileWriter = new FileWriter(fileOutput);
        ) {
            // 读取文件，一个接一个
            while ((length = fileReader.read()) != -1) {
                // 写出字符，一个接一个
                fileWriter.write(length);
            }
            // 刷新流，将数据写出
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 字符流拷贝文件  自定义缓冲区
     * 复制的文件不能打开
     *
     * @param
     */
    public static void copyImageByMyBufferedCharStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 创建字符缓冲区，用于存储数据
        char[] ch = new char[1024 << 7];
        // 存储字符数目
        int length = -1;
        // JDK 7 自动关闭资源
        try (
                FileReader fileReader = new FileReader(fileInput);
                FileWriter fileWriter = new FileWriter(fileOutput);
        ) {
            // 读取文件
            while ((length = fileReader.read(ch)) != -1) {
                // 写出文件
                fileWriter.write(ch, 0, length);
            }
            // 刷新流，将数据写出
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 使用缓冲字符流拷贝文件
     * 拷贝的文件也不能正常读取
     *
     * @param fileInput
     * @param fileOutput
     */
    public static void copyImageByBufferedCharStream(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 读取到一行的数据
        String content = null;
        // JDK7 自动关闭资源
        try (
                FileReader fileReader = new FileReader(fileInput);
                FileWriter fileWriter = new FileWriter(fileOutput);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            // 读取文件
            while ((content = bufferedReader.readLine()) != null) {
                // 写出文件
                bufferedWriter.write(content);
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 使用字符缓冲流拷贝文件
     * 拷贝的文件也不能正常读取
     *
     * @param fileInput
     * @param fileOutput
     */
    public static void copyImageByBufferedCharStream2(File fileInput, File fileOutput) {
        long start = System.currentTimeMillis();
        // 记录字符个数
        int content = -1;
        try (
                FileReader fileReader = new FileReader(fileInput);
                FileWriter fileWriter = new FileWriter(fileOutput);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            // 读取文件
            while ((content = bufferedReader.read()) != -1) {
                // 写出文件
                bufferedWriter.write(content);
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
