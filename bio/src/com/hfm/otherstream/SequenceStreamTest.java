package com.hfm.otherstream;

import java.io.*;
import java.util.*;

/**
 * 合并流(序列流)
 * 用于合并或切割二进制文件
 *
 * @author hfm
 */
public class SequenceStreamTest {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file-io\\Resources\\Knowledge_2.txt");
        File file2 = new File("file-io\\Resources\\OtherStream_3.txt");
        File fileOutput = new File("file-io\\Resources\\序列流合并.txt");
        try (
                // 拷贝二进制文件时使用字节流
                FileInputStream fileInputStream1 = new FileInputStream(file1);
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
        ) {
            // 记录字节个数
            int length = -1;
            // 存储读取到的字节数据
            byte[] b = new byte[1024 << 3];
            // 读取数据
            while ((length = sequenceInputStream.read(b)) != -1) {
                System.out.println(new String(b, 0, length));
                fileOutputStream.write(b, 0, length);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        testSequenceInputStream();
//        mergeFile();
//        mergeFile2();
//        mergeFile3();
        cutFile();
    }

    /**
     * 合并多个流
     * 将多个流方到集合中
     */
    public static void testSequenceInputStream() {
        File file1 = new File("file-io\\Resources\\Knowledge_2.txt");
        File file2 = new File("file-io\\Resources\\OtherStream_3.txt");
        File file3 = new File("file-io\\Resources\\CharacterStream_4.txt");
        File fileOutput = new File("file-io\\Resources\\序列流合并_2.txt");
        // 记录字节个数
        int length = -1;
        // 存储读取到的字节数据
        byte[] b = new byte[1024 << 3];
        try (
                FileInputStream in1 = new FileInputStream(file1);
                FileInputStream in2 = new FileInputStream(file2);
                FileInputStream in3 = new FileInputStream(file3);
                FileOutputStream out = new FileOutputStream(fileOutput);
        ) {
            // 将多个流放入集合中
            LinkedHashSet<InputStream> set = new LinkedHashSet<InputStream>();
            set.add(in1);
            set.add(in2);
            set.add(in3);
            // 获取集合迭代器对象
            final Iterator<InputStream> iter = set.iterator();
            // 传入一个迭代器对象，需要输入Enumeration，需要重写其方法，间接调用其方法，达到相同的效果
            // 匿名内部类
            // 将迭代器 Iterator 转化位 Enumration 迭代器，并将Enumeration 迭代器传入 SequenceInputStream 流
            SequenceInputStream sin = new SequenceInputStream(new Enumeration<InputStream>() {
                @Override
                public boolean hasMoreElements() {
                    return iter.hasNext();
                }

                @Override
                public InputStream nextElement() {
                    return iter.next();
                }
            });
            // 读取数据
            while ((length = sin.read(b)) != -1) {
                System.out.println(new String(b, 0, length));
                out.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 合并 flv 文件
     */
    public static void mergeFile2() throws IOException {
        long start = System.currentTimeMillis();
        // 创建存储音乐的文件夹对象
        File dir = new File("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\");
        // 获取到文件夹中的所有子文件
        File[] files = dir.listFiles();
        Vector<FileInputStream> inputStreams = new Vector<>();
        // 遍历数组，将 flv 文件加入到 vector 集合中
        for (File file : files) {
            if (file.getName().contains("轩")) {
                System.out.println(file.getName());
                inputStreams.add(new FileInputStream(file));
            }
        }
        // 创建一个输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\轩子合集_2.flv");
        // 创建一个序列流对象
        SequenceInputStream inputStream = new SequenceInputStream(inputStreams.elements());
        byte[] buf = new byte[1024 << 3];
        int length = -1;
        // 边读边写
        while ((length = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, length);
        }
        // 关闭资源
        fileOutputStream.close();
        inputStream.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 合并 flv 文件
     */
    public static void mergeFile() throws IOException {
        long start = System.currentTimeMillis();
        // 创建存储音乐的文件夹对象
        File dir = new File("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\");
        // 获取到文件夹中的所有子文件
        File[] files = dir.listFiles();
        ArrayList<FileInputStream> inputStreams = new ArrayList<>();
        // 遍历数组，将 flv 文件加入到 vector 集合中
        for (File file : files) {
            if (file.getName().contains("轩")) {
                System.out.println(file.getName());
                inputStreams.add(new FileInputStream(file));
            }
        }
        // 创建一个输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\轩子合集_1.flv");
        ListIterator<FileInputStream> iterator = inputStreams.listIterator();
        // 创建一个序列流对象
        SequenceInputStream inputStream = new SequenceInputStream(new Enumeration<InputStream>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }
            @Override
            public InputStream nextElement() {
                return iterator.next();
            }
        });
        byte[] buf = new byte[1024 << 3];
        int length = -1;
        // 边读边写
        while ((length = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, length);
        }
        // 关闭资源
        fileOutputStream.close();
        inputStream.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 合并 flv 文件
     */
    public static void mergeFile3() throws IOException {
        long start = System.currentTimeMillis();
        File dir = new File("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\");
        File[] files = dir.listFiles();
        // 创建一个 Vector 对象存储 FileInputStream 对象
        Vector<FileInputStream> vector = new Vector<FileInputStream>();
        // 遍历数组，
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().contains("轩")) {
                System.out.println(files[i].getName());
                vector.add(new FileInputStream(files[i]));
            }
        }
        // 创建一个序列流对象
        SequenceInputStream inputStream = new SequenceInputStream(vector.elements());
        // 创建一个输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\OneDrive - cjlu.edu.cn\\视频 - ASMR\\轩子合集_3.flv");
        // 边读边写
        byte[] buf = new byte[1024 << 3];
        int length = 0;
        while ((length = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, length);
        }
        // 关闭资源
        fileOutputStream.close();
        inputStream.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 切割 文件
     */
    public static void cutFile() throws IOException {
        File file = new File("file-io\\Resources\\P1 File 类的概述.flv");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024 << 12];
        int length = -1;
        int count = 1;
        while ((length = fileInputStream.read(buf)) != -1) {
            // 每读取一次，则生成一个文件
            FileOutputStream fileOutputStream = new FileOutputStream("file-io\\Resources\\P1 File 类的概述 part " + count + ".flv");
            // 把读取到的数据写出
            fileOutputStream.write(buf, 0, length);
            count++;
            // 关闭资源
            fileOutputStream.close();
        }
        // 关闭资源
        fileInputStream.close();
    }
}
