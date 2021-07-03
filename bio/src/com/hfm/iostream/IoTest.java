package com.hfm.iostream;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-01 10:05
 */
public class IoTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        writFileTest();
        readFileTest();
    }

    /**
     * 写入文件
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void writFileTest() throws FileNotFoundException, IOException {
        // 创建文件对象
        File file = new File("bio\\Resources\\txt\\IOTestFile.txt");
        // 如果文件不存在则创建即可
        file.createNewFile();
        // 创建文件输出流
        FileOutputStream fos = new FileOutputStream(file);
        fos.write('g');
        fos.write('z');
        fos.write('i');
        fos.write('t');
        fos.write('c');
        fos.write('a');
        fos.write('s');
        fos.write('t');
        fos.close();
    }

    /**
     * 读取文件
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void readFileTest() throws FileNotFoundException, IOException {
        // 创建文件对象
        File file = new File("bio\\Resources\\txt\\IOTestFile.txt");
        // 如果文件不存在则创建即可
        file.createNewFile();
        // 创建文件输入流
        FileInputStream fis = new FileInputStream(file);
        // 有对多长，就读多少字节。
        for (int i = 0; i < file.length(); i++) {
            System.out.print((char) fis.read());
        }
        fis.close();
    }
}
