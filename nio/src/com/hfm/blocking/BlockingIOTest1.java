package com.hfm.blocking;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description /**
 * * 通道 channel 负责连接
 * * java.io.channels.Channel 接口
 * *                  |-- SelectableChannel 抽象类
 * *                      |-- SocketChannel
 * *                      |-- ServcrSocketChannel TCP
 * *                      |-- DatagramChannel  UDP
 * *
 * *                      |-- Pipe.SinkChannel
 * *                      |-- Piep.SourceChannel
 * @date 2020-05-05 21:21
 */
public class BlockingIOTest1 {
    /**
     * 客户端
     */
    @Test
    public void client() {
        try (
                // 1.获取通道
                SocketChannel open = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));
                // 建立本地文件的通道，将文件写出
                FileInputStream fileInputStream = new FileInputStream("D:\\Code\\core-java\\nio\\Resources\\text.txt");
                FileChannel fileChannel = fileInputStream.getChannel()
        ) {
            // 2.创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                // 缓冲区设置为读取状态
                byteBuffer.flip();
                // 通过网络 channeL 通道传递数据
                open.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端
     */
    @Test
    public void service() {
        try (
                // 1.创建服务端通道
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                // 创建输出通道
                FileChannel fileChannel = FileChannel.open(Paths.get("D:\\Code\\core-java\\nio\\Resources\\copy5.txt"), WRITE, READ, CREATE)
        ) {
            // 2.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8000));
            // 3.获取客户端连接通道
            SocketChannel accept = serverSocketChannel.accept();
            // 4.创建缓冲区，用于存储数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (accept.read(byteBuffer) != -1) {
                // 设置为读取数据模式
                byteBuffer.flip();
                // 将缓冲区的数据传入输出通道
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
