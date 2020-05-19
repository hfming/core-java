package com.hfm.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author shkstart
 * @create 2019 下午 4:54
 */
public class URLConnectionTest {
    public static void main(String[] args) {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        try (
                FileOutputStream fos = new FileOutputStream("socket\\Resources\\URLConnection.html")
        ) {
            // 创建 URL 对象
            URL url = new URL("https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/net/URLConnection.html");
            // 获取HttpURLConnection 对象
            urlConnection = (HttpURLConnection) url.openConnection();
            // 连接 URL
            urlConnection.connect();

            // 获取输入流对象
            is = urlConnection.getInputStream();

            byte[] buffer = new byte[1024 << 3];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}