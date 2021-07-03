package com.hfm.blocking;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-16 22:02
 * @Description
 * @date 2021/6/16
 */
public class BIO {
    /**
     * 客户端
     */
    @Test
    public void client() {
        try (
                Socket socket = new Socket("127.0.0.1", 8000);
                // 建立本地文件的通道，将文件写出
                FileInputStream fileInputStream = new FileInputStream("D:\\Code\\core-java\\nio\\Resources\\text.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                OutputStream outputStream = socket.getOutputStream()
        ) {
            int length;
            byte[] bytes = new byte[2 << 10 << 8];
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
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
                ServerSocket serverSocket = new ServerSocket(8000);
                FileOutputStream fileOutputStream = new FileOutputStream("Resources\\copy7.txt");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream()
        ) {
            int length;
            byte[] bytes = new byte[2 << 10 << 8];

            // 拷贝数据
            while ((length = inputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
                System.out.println(new String(bytes,0,length));
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
