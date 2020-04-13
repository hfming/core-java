package com.hfm.execption;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hfm
 * @version 1.01 2020-04-07 22:43
 * @date 2020/4/7
 */
public class IOExecptionTest {
    public static void main(String[] args) {
//        FileInputStream in = new FileInputStream("atguigushk.txt");
//        int b;
//        b = in.read();
//        while (b != -1) {
//            System.out.print((char) b);
//            b = in.read();
//        }
//        in.close();
        try {
            FileInputStream in = new FileInputStream("atguigushk.txt");
            int b;
            b = in.read();
            while (b != -1) {
                System.out.print((char) b);
                b = in.read();
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println(" It’s ok!");
        }
    }
}
