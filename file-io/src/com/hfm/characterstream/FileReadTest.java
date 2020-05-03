package com.hfm.characterstream;

import java.io.*;

public class FileReadTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long l1 = readTest();
        long l2 = readTest1();
        long l3 = readTest2();
        // 48628 690 1067
        System.out.println(l1 + "\t" + l2 + "\t" + l3);
    }

    /**
     * 使用缓冲输入字符流读取。
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static long readTest2() throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        File file = new File("file-io\\Resources\\IMG_1.jpg");
        // 建立文件的输入通道。
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // 读取文件的数据
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            // 每次只会读取一个字符数据，建议使用缓冲输入字符流
            System.out.println(line);
        }
        // 关闭资源
        bufferedReader.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
        return end - start;
    }

    /**
     * 使用缓冲输入字符流读取。
     */
    public static long readTest1() throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        File file = new File("file-io\\Resources\\IMG_1.jpg");
        // 建立文件的输入通道。
        FileReader fileReader = new FileReader(file);
        // 读取文件的数据,记录读取的字符数目
        int line = -1;
        // 创建字符缓冲区
        char[] c = new char[1024 << 3];
        // 循环读取
        while ((line = fileReader.read(c)) != -1) {
            // 根据读取到的字符个数创建字符串
            System.out.println(new String(c, 0, line));
        }
        // 关闭资源
        fileReader.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
        return end - start;
    }

    /**
     * 使用缓冲输入字符流读取。
     * 时间长，效率低，建议使用缓冲区
     */
    public static long readTest() throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        File file = new File("file-io\\Resources\\IMG_1.jpg");
        // 建立文件的输入通道。
        FileReader fileReader = new FileReader(file);
        // 读取文件的数据,记录读取的字符数目
        int line = -1;
        while ((line = fileReader.read()) != -1) {
            // 每次只会读取一个字符数据，建议使用缓冲输入字符流
            System.out.print((char) line);
        }
        // 关闭资源
        fileReader.close();
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("运行时间：" + (end - start));
        return end - start;
    }

    /**
     * 使用缓冲输入字符流读取。
     * 没有进行循环只能读取一个字符数组的长度数据
     */
    public static long readTest3() throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        File file = new File("file-io\\Resources\\IMG_1.jpg");
        // 建立文件的输入通道。
        FileReader fileReader = new FileReader(file);
        // 读取文件的数据,记录读取的字符数目
        int line = -1;
        // 创建字符缓冲区
        char[] c = new char[1024 << 3];
        // 没有循环读取
        line = fileReader.read(c);
        System.out.println(new String(c, 0, line));
        // 关闭资源
        fileReader.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
        return end - start;
    }

    /**
     * 使用缓冲输入字符流读取。
     * 没有进行循环只能读取一个字符数组的长度数据
     * 发现读出的数据有很多0，原因是因为创建字符串时，没有根据读取到的字符个数创建字符串
     */
    public static long readTest4() throws FileNotFoundException, IOException {
        long start = System.currentTimeMillis();
        File file = new File("file-io\\Resources\\IMG_1.jpg");
        // 建立文件的输入通道。
        FileReader fileReader = new FileReader(file);
        // 读取文件的数据,记录读取的字符数目
        // 创建字符缓冲区
        char[] c = new char[1024 << 3];
        fileReader.read(c);
        // 创建字符串时，没有根据读取到的字符个数创建字符串
        System.out.println(new String(c));
        // 关闭资源
        fileReader.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
        return end - start;
    }

    /**
     * 自己实现一个 readLine 方法。
     *
     * @param fileReader
     * @return
     * @throws IOException
     */
    public static String myReadLine(FileReader fileReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int content = 0;
        while ((content = fileReader.read()) != -1) {
            if (content == '\r') {
                continue;
            } else if (content == '\n') {
                return sb.toString();
            } else {
                // 正常的字符
                sb.append((char) content);
            }
        }
        return null;
    }
}
