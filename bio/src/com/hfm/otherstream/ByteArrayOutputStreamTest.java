package com.hfm.otherstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-05 11:44
 */
public class ByteArrayOutputStreamTest {
    @Test
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("Resources\\txt\\a.txt");

        System.out.println(readStringFromInputStream1(fis));

        System.out.println(readStringFromInputStream2(fis));

        System.out.println(readStringFromInputStream(fis));
    }

    /**
     * 方式一：
     *
     * @param fis
     * @return
     * @throws IOException
     */
    private String readStringFromInputStream1(FileInputStream fis) throws IOException {
        String content = "";
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            content += new String(buffer, 0, len);
        }
        return content;
    }

    /**
     * 方式二：BufferedReader
     *
     * @param fis
     * @return
     * @throws IOException
     */
    private String readStringFromInputStream2(FileInputStream fis) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String content;
        String str = "";
        while ((content = reader.readLine()) != null) {
            str += content + "\r\n";
        }
        return str;
    }

    /**
     * 方式三：避免出现乱码
     * ByteArrayOutputStream 内部有 32位 的字节数组作为缓冲区
     *
     * @param fis
     * @return
     * @throws IOException
     */
    private String readStringFromInputStream(FileInputStream fis) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        while ((len = fis.read()) != -1) {
            baos.write(len);
        }
        return baos.toString();
    }
}