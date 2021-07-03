package com.hfm.tcp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-10 20:58
 */
public class PictureRunnable implements Runnable {
    private Socket accept;
    private byte[] bytes;
    private int length;

    public PictureRunnable(Socket accept, byte[] bytes, int length) {
        this.accept = accept;
        this.bytes = bytes;
        this.length = length;
    }

    @Override
    public void run() {
        try (
                FileInputStream fileInputStream = new FileInputStream(new File("socket\\Resources\\1.jpg"));
                // 使用 ByteArrayOutputStream 解决可能出现的乱码问题
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ) {
            while ((length = fileInputStream.read(bytes)) != -1) {
                accept.getOutputStream().write(bytes, 0, length);
            }
            // 输出停止标志
            accept.shutdownOutput();

            length = 0;
            // 接受客户端传入的数据
            while ((length = accept.getInputStream().read(bytes)) != -1) {
                // 使用 ByteArrayOutputStream 解决乱码问题
                baos.write(bytes, 0, length);
            }
            System.out.println(baos.toString());
            System.out.println("服务端 - 图片接收成功!");

            accept.shutdownInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
