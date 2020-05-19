package com.hfm.otherstream;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-04 19:16
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        read();
        // write();
        read2();
    }

    private static void read2() throws IOException {
        // 文件可读可写
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(5);
//        //方式一：
//        StringBuilder info = new StringBuilder((int) file.length());
//        byte[] buffer = new byte[10];
//        int len;
//        while ((len = raf1.read(buffer)) != -1) {
//            //info += new String(buffer,0,len);
//            info.append(new String(buffer, 0, len));
//        }
        //方式二：
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[10];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
    }

    @Test
    public void write() throws IOException {
        // 设置访问模式为可读可写
        RandomAccessFile raf = new RandomAccessFile("D:\\Code\\core-java-simple\\file-io\\Resources\\txt\\CharacterStream.txt", "rw");
        raf.seek(5);
        //先读出来
        String temp = raf.readLine();
        raf.seek(5);
        raf.write("xyz".getBytes());
        raf.write(temp.getBytes());
        raf.close();
    }

    private static void read() throws IOException {
        // 设置访问模式为可读可写
        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        // 设置文件指针偏移量，从该文件的开头测量，下一次读取或写入发生。
        // 将文件记录指针定位到 pos 位置
        raf.seek(5);
        byte[] b = new byte[1024];
        int off = 0;
        int len = 5;
        raf.read(b, off, len);
        String str = new String(b, 0, len);
        System.out.println(str);
        raf.close();
    }

    /**
     * * RandomAccessFile的使用
     * * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
     * * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
     * * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
     * *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
     * * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
     */
    @Test
    public void test1() {
        try (
                RandomAccessFile raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
                RandomAccessFile raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        // 将指针调到角标为3的位置
        raf1.seek(3);
        // 从指针 3 开始覆盖
        raf1.write("xyz".getBytes());
        raf1.close();
    }

    /**
     * 使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        // 将指针调到角标为3的位置
        raf1.seek(3);
        // 保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        // 调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        // 将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());
        raf1.close();
        // 思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
