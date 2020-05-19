package com.hfm.otherstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-04 18:49
 */
public class DataOutputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建连接到指定文件的数据输出流对象
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("destData.dat"));
        ) {
            // 写UTF字符串
            dos.writeUTF("我爱北京天安门");
            // 写入布尔值
            dos.writeBoolean(false);
            // 写入长整数
            dos.writeLong(1234567890L);
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
            // 关闭流对象
        }
    }
}
