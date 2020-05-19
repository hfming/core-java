package com.hfm.tcp;

        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.util.concurrent.ArrayBlockingQueue;
        import java.util.concurrent.Executors;
        import java.util.concurrent.ThreadPoolExecutor;
        import java.util.concurrent.TimeUnit;

/**
 * 服务端：服务端设置为线程
 * 客户端：浏览器，需要浏览器进行连接
 *
 * @author hfm
 */
public class BrowserServer {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println("服务器启动！");
        byte[] b = new byte[1024 << 3];
        int len = 0;
        try (
                // 1. 建立服务端的服务
                ServerSocket serverSocket = new ServerSocket(9000)
        ) {
            // 2. 接受客户端的连接
            while (true) {
                // 3.获取客户端连接
                Socket socket = serverSocket.accept();
                // 4.提交任务
                threadPoolExecutor.submit(new BrowserRunnable(socket, b, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
