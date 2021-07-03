package com.hfm.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 20:25
 */
public class ScatterAndGatter {
    public static void main(String[] args) {
        try (
                // 建立RandomAccessFile 输入对象，模式设置为可读
                RandomAccessFile input = new RandomAccessFile("nio\\Resources\\text.txt", "r");
                // 建立RandomAccessFile 输出对象，模式设置为可写
                RandomAccessFile out = new RandomAccessFile("nio\\Resources\\copy4.txt", "rw");

                // 获取 channel 通道
                FileChannel inputChannel = input.getChannel();
                FileChannel outChannel = out.getChannel()
        ) {
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(1024);

            ByteBuffer[] byteBuffers = {byteBuffer1, byteBuffer2, byteBuffer3};
            // 分散读取
            inputChannel.read(byteBuffers);

            for (ByteBuffer byteBuffer : byteBuffers) {
                // 设置为读取模式
                byteBuffer.flip();
            }

            // 聚集写入
            outChannel.write(byteBuffers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
