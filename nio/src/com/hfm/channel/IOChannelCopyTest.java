package com.hfm.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 使用 Channel copy 数据 间接缓冲区读取文件
 * @date 2020-05-05 19:14
 */
public class IOChannelCopyTest {
    public static void main(String[] args) {
        File file = new File("nio\\Resources\\text.txt");
        File out = new File("nio\\Resources\\copy.txt");
        try (
                // 创建输入流
                FileInputStream fileInputStream = new FileInputStream(file);
                // 创建输入流通道
                FileChannel fileChannel = fileInputStream.getChannel();

                // 创建输出流
                FileOutputStream fileOutputStream = new FileOutputStream(out);
                // 创建输出流通道
                FileChannel outChannel = fileOutputStream.getChannel()
        ) {
            // channel 自身不能够存储数据，只具有传递数据的作用，需要创建 Buffer 缓冲区了存储数据
            // 创建间接缓冲区，直接缓冲区不用通过 channel 来传输数据，而是通过 mapBuffer 来传输数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int num = -1;
            // 将输入通道中的数据读取到缓冲区中
            while ((num = fileChannel.read(byteBuffer)) != -1) {
                // 将输出缓冲区中的数据写入通道
                // 切换成读数据模式
                byteBuffer.flip();
                // 将缓冲区中的数据写入输出通道
                outChannel.write(byteBuffer);
                // 清空缓冲区，实际上数据并没有清空，只是将 capacity limit position 回复默认值，数据处于遗忘的状态
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
