package com.hfm.bocking;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-06 11:01
 */
public class PipeTest {
    @Test
    public void test() {
        Pipe send = null;
        Pipe.SinkChannel sinkChannel = null;
        Pipe.SourceChannel source = null;
        ByteBuffer byteBuffer = null;
        try {
            // 1.获取 pipe 管道
            send = Pipe.open();
            // 2.创建缓冲区用于存储数据
            byteBuffer = ByteBuffer.allocate(1024);
            // 3. 返回此管道的接收器通道 通过管道创建通道
            sinkChannel = send.sink();
            // 4.转化为非阻塞通道
            sinkChannel.configureBlocking(false);

            byteBuffer.put("pipe 传输数据！".getBytes());
            // 转化成读取模式
            byteBuffer.flip();
            sinkChannel.write(byteBuffer);

            // 获取数据源通道
            source = send.source();
            // 转化为非阻塞通道
            source.configureBlocking(false);
            // 获取选择器
            Selector selector = Selector.open();
            // 注册通道
            source.register(selector, SelectionKey.OP_READ);
            // 采用轮询方式获取已经准备好的通道
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    System.out.println(byteBuffer.position());

                    if (selectionKey.isReadable()) {
                        // 设置成读取模式
                        byteBuffer.flip();
                        int read = source.read(byteBuffer);
                        System.out.println(new String(byteBuffer.array(), 0, read));
                        byteBuffer.clear();
                    }
                    if (selectionKey.isValid()) {

                    }
                    if (selectionKey.isWritable()) {

                    }
                    if (selectionKey.isAcceptable()) {

                    }
                    if (selectionKey.isConnectable()) {

                    }
                    // 删除已经处理的通道
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (source != null) {
                try {
                    source.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (sinkChannel != null) {
                        try {
                            sinkChannel.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
