package com.hfm.channel;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 直接缓冲区 拷贝数据方式二
 * @date 2020-05-05 20:09
 */
public class ChannelToChannel {
    public static void main(String[] args) {
        try (
                // 使用 FileChannel.open(file,Option) 方法创建 输入Channel
                FileChannel read = FileChannel.open(Paths.get("nio\\Resources\\text.txt"), StandardOpenOption.READ);
                // StandardOpenOption.CREATE 如果文件存在，覆盖
                // StandardOpenOption.CREATENew 如果文件存在，报错
                FileChannel write = FileChannel.open(Paths.get("nio\\Resources\\copy3.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)
        ) {
            // 通道与通道之间直接传递数据
            read.transferTo(0, read.size(), write);

            // 相同的效果
            // write.transferFrom(read, 0, read.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
