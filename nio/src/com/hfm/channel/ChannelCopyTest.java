package com.hfm.channel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 19:14
 */
public class ChannelCopyTest {
    /**
     * 使用 Channel copy 数据 间接缓冲区读取文件
     */
    @Test
    public  void nonDirectBufferedChannel() {
        long start = System.currentTimeMillis();
        File file = new File("Resources\\P1 File 类的概述.flv");
        File out = new File("Resources\\P1 File 类的概述 copy.flv");
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
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024<<8);

            // 将输入通道中的数据读取到缓冲区中
            while (fileChannel.read(byteBuffer) != -1) {
                // 将输出缓冲区中的数据写入通道
                // 切换成读数据模式
                byteBuffer.flip();
                // 将缓冲区中的数据写入输出通道
                outChannel.write(byteBuffer);
                // 清空缓冲区，实际上数据并没有清空，只是将 capacity limit position 回复默认值，数据处于遗忘的状态
                byteBuffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 使用 Channel copy 数据 直接缓冲区读取文件
     */
    @Test
    public  void directBufferedChannel() {
        long start = System.currentTimeMillis();
        try (
                // 使用 FileChannel.open(file,Option) 方法创建 输入Channel
                FileChannel read = FileChannel.open(Paths.get("Resources\\P1 File 类的概述.flv"), StandardOpenOption.READ);
                // StandardOpenOption.CREATE 如果文件存在，覆盖
                // StandardOpenOption.CREATENew 如果文件存在，报错
                FileChannel write = FileChannel.open(Paths.get("Resources\\P1 File 类的概述 copy.flv"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)
        ) {
            // channel 自身不能够存储数据，只具有传递数据的作用，需要创建 Buffer 缓冲区了存储数据
            // 创建缓冲区
            // 内存映射文件，现在的缓冲区在物理内存中
            // 传入 MapMode 设置 Map 缓冲区模式
            // FileChannel.MapMode.READ_ONLY 只读
            MappedByteBuffer inputMap = read.map(FileChannel.MapMode.READ_ONLY, 0, read.size());

            // FileChannel.MapMode.READ_WRITE 可读可写
            // 映射 map 与通道的权限要统一，否则会报错 java.nio.channels.NonReadableChannelException
            MappedByteBuffer outMap = write.map(FileChannel.MapMode.READ_WRITE, 0, read.size());

            // 可以直接操作缓冲区，在物理内存中操作数据，不需要通过通道传输数据

            byte[] bytes = new byte[inputMap.limit()];
            // 使用字节数组，将数据读到字节数组中
            inputMap.get(bytes);
            // 使用字节数组，将数据写到 outMap 中
            outMap.put(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    @Test
    public  void directBufferedChannel2() {
        long start = System.currentTimeMillis();
        File file = new File("Resources\\P1 File 类的概述.flv");
        File out = new File("Resources\\P1 File 类的概述 copy.flv");
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
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024<<8);

            // 将输入通道中的数据读取到缓冲区中
            while (fileChannel.read(byteBuffer) != -1) {
                // 将输出缓冲区中的数据写入通道
                // 切换成读数据模式
                byteBuffer.flip();
                // 将缓冲区中的数据写入输出通道
                outChannel.write(byteBuffer);
                // 清空缓冲区，实际上数据并没有清空，只是将 capacity limit position 回复默认值，数据处于遗忘的状态
                byteBuffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
