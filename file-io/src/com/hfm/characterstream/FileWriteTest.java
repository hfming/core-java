package com.hfm.characterstream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
    public static void main(String[] args) throws IOException {
        writeTest3();
    }

    /**
     * 输出字符流
     * 覆盖模式
     *
     * @throws IOException
     */
    private static void writeTest3() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\Test.txt");
        // 建立数据输出通道，覆盖模式
        FileWriter fileWriter = new FileWriter(file);
        // 准备数据，把数据写出
        // write(String str)
        fileWriter.write("马上你们就要做练习了喔！");
        // 刷新流
        fileWriter.close();
    }

    /**
     * 输出字符流
     * 追加模式
     *
     * @throws IOException
     */
    private static void writeTest2() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\Test.txt");
        // 建立数据输出通道，追加模式
        FileWriter fileWriter = new FileWriter(file, true);
        // 准备数据，把数据写出
        // write(String str)
        fileWriter.write("马上你们就要做练习了喔！");
        // 刷新流
        fileWriter.close();
    }

    /**
     * 缓冲输出字符流
     *
     * @throws IOException
     */
    private static void writeTest1() throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\Test.txt");
        // 建立数据输出通道
        FileWriter fileWriter = new FileWriter(file, true);
        // 建立缓冲输出字符流
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        // 准备数据，把数据写出
        // bufferedWriter.write("\r\n");
        bufferedWriter.newLine();
        bufferedWriter.write("马上你们就要做练习了喔！");
        // 刷新一个缓冲区
        bufferedWriter.close();
    }
}
