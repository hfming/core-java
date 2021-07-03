package com.hfm.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
//        read1();
//        read2();
//        read3();
//        read4();
        read6();
    }

    /**
     * 使用字节流实现视频文件拷贝
     * @throws IOException
     */
    public static void read6() throws IOException {
        long startTime = System.currentTimeMillis();
        // 找到目标文件
        File fileInu = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        File fileOut = new File("file-io\\Resources\\test\\P1 File 类的概述 - 副本.flv");
        // 建立数据的通道
        FileInputStream fileInputStream = new FileInputStream(fileInu);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
        // 读取数据
        // 缓冲字节数组的长度一般都是1024的倍数。
        byte[] buf = new byte[2 << 10 << 8];
        // 记录本次读取的自己个数。
        int length = 0;
        while ((length = fileInputStream.read(buf)) != -1) {
            // 输出
            fileOutputStream.write(buf, 0, length);
        }
        // 刷新，并将数据写出
        fileOutputStream.flush();
        // 关闭资源(释放资源文件)
        fileOutputStream.close();
        fileInputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime));
    }

    /**
     * 方式5：采用循环方式，每次读取 1024 个字符，使用循环配合缓冲数组读取,首选方法
     * 运行时间:560
     * 运行时间大大缩短，效率高，推荐使用该方法读取图片，视频，文档
     * 推荐使用
     */
    public static void read5() throws IOException {
        long startTime = System.currentTimeMillis();
        // 找到目标文件
        File file = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        // 建立数据的通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 读取数据
        // 缓冲字节数组的长度一般都是1024的倍数。
        byte[] buf = new byte[2 << 10 << 8];
        // 记录本次读取的自己个数。
        int length = 0;
        while ((length = fileInputStream.read(buf)) != -1) {
            System.out.print(new String(buf, 0, length));
        }
        // 关闭资源(释放资源文件)
        fileInputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime));
    }

    /**
     * 方式4：缓冲区有默认值。没有根据读取到的长度输出
     * 测试发现打印的效果打印出了很多 0，因为数组有默认初始化值。所以，我们将数组的数据全部都遍历和出来。现在需要的是取出数组中的部分数据。
     * 需要将循环条件修改仔细查看api文档。发现该方法 read(byte[] b)返回的是往数组中存入了多少个字节。就是数组实际存储的数据个数。
     * 为什么打印的不是字母而是数字，是字母对应的码值。如何显示字符，强转为 char 或者生成字符串即可
     * 不推荐
     */
    public static void read4() throws IOException {
        long startTime = System.currentTimeMillis();
        // 找到目标文件
        File file = new File("file-io\\Resources\\test\\IOTestFile.txt");
        // 建立数据的通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 读取数据
        // 缓冲字节数组的长度一般都是1024的倍数。
        byte[] buf = new byte[2 << 10 << 8];
        while (fileInputStream.read(buf) != -1) {
            // 没有记录本次读取的自己个数。造成缓冲区有默认值
            for (byte b : buf) {
                System.out.print(b);
            }
        }
        // 关闭资源(释放资源文件)
        fileInputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime));
    }

    /**
     * 方式3：read(byte[] b) 使用（缓冲数组）字节数组读取，无法完整读取一个文件的数据 12G
     * 问题：只能读取 1024个字节，应该循环读取
     * 不推荐使用
     */
    public static void read3() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        // 建立数据的通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 创建一个字节数组，存储文件数据
        // 每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回 -1
        byte[] buf = new byte[2 << 10 << 8];
        // 先把读取到的数据存储到字节数组中，然后返回的是本次读取到字节数。
        int length = fileInputStream.read(buf);
        System.out.println(new String(buf, 0, length));
        fileInputStream.close();
    }

    /**
     * 方式2： 常用循环的方式，每次读取一个字节的数据，可以读取完整文件数据。
     * 问题：每次读取一个效率太慢，建议创建字节缓存数组
     * 运行时间:67335
     * 不推荐
     */
    public static void read2() throws IOException {
        long startTime = System.currentTimeMillis();
        // 第一步：找到目标文件
        File file = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        // 第二步： 建立数据通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 第三步：读取文件的数据
        // 用于保存读取到的数据 虽然读取了一个字节，但是会自动提升为int类型。
        int content = 0;
        // 方法如果读取了文件的末尾则返回-1表示。
        while ((content = fileInputStream.read()) != -1) {
            System.out.print((char) content);
        }
        // 关闭资源
        fileInputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime));
    }

    /**
     * 方式一： read() 读取单个字节，没法读取完整一个文件的数据
     * 问题：只能读取单个字节
     * 不推荐
     */
    public static void read1() throws IOException {
        // 第一步： 找到目标文件对象
        File file = new File("file-io\\Resources\\test\\P1 File 类的概述.flv");
        // 第二步： 建立数据的输入通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 第三步： 读取文件数据
        // 返回的是读取的字节数据，每次只会读取一个字节。
        int content = fileInputStream.read();
        System.out.println("读到的内容：" + (char) content);
        // 第四步：关闭资源(释放资源文件)
        fileInputStream.close();
    }
}
