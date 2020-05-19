package com.hfm.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
//		write1();
        write2();
    }

    /**
     * 方式二：先把数据转成字节数组然后再写出。
     * 推荐使用该模式
     */
    public static void write2() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\test\\Output.txt");
        // 建立数据的输出通道
        // 第二个参数为true时写入文件数据就是以追加的形式写入的
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        // 准备数据， 把数据写出
        // 可以写出中文
        String str = "\r\nhello world\r\n中文测试";
        // 把字符串转成字节数组
        byte[] buf = str.getBytes();
        // 把字节数组写出
        fileOutputStream.write(buf);
        // 关闭资源
        fileOutputStream.close();
    }

    /**
     * 方式一：write(int b) 每次只能写一个字节的数据。
     * 问题：每次只能写一个字节的数据，且高24位被截断，不能写出中文
     */
    public static void write1() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\test\\Output.txt");
        // 建立数据的输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        // 把数据写出
        fileOutputStream.write('h');
        fileOutputStream.write('e');
        fileOutputStream.write('l');
        fileOutputStream.write('l');
        fileOutputStream.write('o');
        // 要写入的字节是参数 b的八个低位。b的 24个高位将被忽略。
        fileOutputStream.write('中');
        fileOutputStream.write('文');
        fileOutputStream.write('测');
        fileOutputStream.write('试');
        // 关闭资源
        fileOutputStream.close();
    }
}
