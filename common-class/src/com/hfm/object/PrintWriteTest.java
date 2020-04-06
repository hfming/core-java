package com.hfm.object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class PrintWriteTest {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Code\\core-java-simple\\common-class\\src\\com\\hfm\\object\\PrintWriteTest1.java");

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write("new test.");

        printWriter.close();
    }
}
