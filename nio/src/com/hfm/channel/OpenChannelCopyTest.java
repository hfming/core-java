package com.hfm.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 使用 Channel copy 数据 直接缓冲区读取文件
 * @date 2020-05-05 19:14
 */
public class OpenChannelCopyTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (
                // 使用 FileChannel.open(file,Option) 方法创建 输入Channel
                FileChannel read = FileChannel.open(Paths.get("nio\\Resources\\text.txt"), StandardOpenOption.READ);
                // StandardOpenOption.CREATE 如果文件存在，覆盖
                // StandardOpenOption.CREATENew 如果文件存在，报错
                FileChannel write = FileChannel.open(Paths.get("nio\\Resources\\copy2.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)
        ) {
            // channel 自身不能够存储数据，只具有传递数据的作用，需要创建 Buffer 缓冲区了存储数据
            // 创建缓冲区
            // 内存映射文件，现在的缓冲区在物理内存中
            MappedByteBuffer minpuMap = read.map(FileChannel.MapMode.READ_ONLY, 0, read.size());

            // FileChannel.MapMode.READ_WRITE 可读可写
            MappedByteBuffer outMap = write.map(FileChannel.MapMode.READ_WRITE, 0, read.size());

            // 可以直接操作缓冲区，在物理内存中操作数据，不需要通过通道传输数据

            byte[] bytes = new byte[minpuMap.limit()];
            // 使用字节数组，将数据读到字节数组中
            minpuMap.get(bytes);
            // 使用字节数组，将数据写到 outMap 中
            outMap.put(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
