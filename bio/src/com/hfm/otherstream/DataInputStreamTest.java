package com.hfm.otherstream;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-04 18:48
 */
public class DataInputStreamTest {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("destData.dat"));
        ) {
            String info = dis.readUTF();
            boolean flag = dis.readBoolean();
            long time = dis.readLong();
            System.out.println(info);
            System.out.println(flag);
            System.out.println(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
