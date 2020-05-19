package com.hfm.otherstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流
 */
public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        // 找到目标文件
        File file = new File("file-io\\Resources\\a.txt");
        // 建立数据的输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // 写出数据
        fileOutputStream.write("97ass中文".getBytes());
        // 刷新流
        fileOutputStream.flush();
        // 关闭资源
        fileOutputStream.close();

        /**
         * 作用１：可以为我们打印任意类型的数据，而且打印数据之前会先转换成字符串然后再打印。
         */
        // 找到目标文件
        File file1 = new File("file-io\\Resources\\a.txt");
        // 建立打印流对象
        PrintStream printStream = new PrintStream(file1);
        // 打印数据
        // 打印流不需要输出字符串的字节数组，可以直接输出所有类型数据
        printStream.println(97);
        printStream.println(true);
        printStream.println(3.14);
        // 关闭资源
        printStream.close();

        // 标准的输出流默认是指控制台，可以进行修改。
        PrintStream printStream11 = new PrintStream(new File("file-io\\Resources\\a.txt"));
        // 修改标准的输出流
        System.setOut(printStream11);
        // 输出打印到 a.txt 文件中而不是控制台，因为已经修改了标准的输出流
        System.out.println("hehe");

        /**
         * 作用 2： 收集日志信息
         */
        // 追加的形式
        FileOutputStream fileOutputStream1 = new FileOutputStream(new File("file-io\\Resources\\20150519.log"), true);
        PrintStream printStream1 = new PrintStream(fileOutputStream1);
        try {
            String str = null;
            System.out.println("字符个数：" + str.length());
            int result = 4 / 0;
        } catch (Exception e) {
            // 将日志信息往打印流中打印
            e.printStackTrace(printStream1);
        }
    }
}
