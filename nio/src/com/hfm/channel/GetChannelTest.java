package com.hfm.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description channel 用于源节点与目标节点的连接
 * @date 2020-05-05 18:39
 */
public class GetChannelTest {
    public static void main(String[] args) throws IOException {
        // channel 用于源节点与目标节点的连接
        // 在 Java NIO 中负责缓冲区中数据的传输。
        // channel 自身没有读取数据的能力，需要通过流配合缓冲区进行数据传输操作

        /**
         * 获取通道的方式一：通过本地IO类或者网络IO类的方法来获取 channel
         */
        // 本地 IO 类获取 Channel
        FileInputStream fileInputStream = new FileInputStream("nio\\Resources\\text.txt");
        // 获取 FileChannel
        FileChannel channel1 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("nio\\Resources\\text.txt");
        // 获取 FileChannel
        FileChannel channel2 = fileOutputStream.getChannel();

        // 随机读取文件类，模式设置为可读可写
        RandomAccessFile randomAccessFile = new RandomAccessFile("nio\\Resources\\text.txt", "rw");
        // 获取 FileChannel
        FileChannel channel3 = randomAccessFile.getChannel();

        // IO 类获取 Channel
        Socket socket = new Socket();
        // 获取 SocketChannel
        SocketChannel socketChannel = socket.getChannel();

        DatagramSocket datagramSocket = new DatagramSocket();
        // 获取DatagramChannel
        DatagramChannel datagramChannel = datagramSocket.getChannel();

        ServerSocket serverSocket = new ServerSocket();
        // 获取 ServerSocketChannel
        ServerSocketChannel serverSocketCnnel = serverSocket.getChannel();

        /**
         * 获取channel 的方法二：JDK 1.7 时对NIO 进行大量的改进，我们把它称为 NIO 2，ji即 AIO
         * NIO 2 针对各个通道提供了静态的 open 方法来获取各个Channel通道
         */
        //    StandardOpenOption 枚举类
        //    READ, 读取
        //    WRITE, 写
        //    APPEND,
        //    TRUNCATE_EXISTING,
        //    CREATE, 创建， 如果存在不会报错
        //    CREATE_NEW, 创建新，如果存在会报错
        //    DELETE_ON_CLOSE,
        //    SPARSE,
        //    SYNC,
        //    DSYNC;
        FileChannel read = FileChannel.open(Paths.get("nio\\Resources\\text.txt"), StandardOpenOption.READ);
        FileChannel write = FileChannel.open(Paths.get("nio\\Resources\\write.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        /**
         * 获取 Channel 的方式三：JDK 1.7 的 Files工具类的方法 newByteChannel()  获取字节通道。
         */
//        SeekableByteChannel seekableByteChannel = Files.newByteChannel("nio\\Resources\\text.txt", StandardOpenOption.READ,StandardOpenOption.CREATE);
    }
}
