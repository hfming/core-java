package com.hfm.characterstream;

import java.io.*;
import java.util.TreeSet;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 请将文本信息恢复顺序
 * 1. 逐行读取文本信息。
 * 2. 解析文本信息到集合中。
 * 3. 遍历集合，按顺序，写出文本信息。
 * @date 2020-05-03 16:57
 */
public class TextSortTest {
    public static void main(String[] args) {
        TreeSet<String> textSet = new TreeSet<>();
        // JDK 7 自动关闭 IO 流
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader("file-io\\Resources\\in.txt"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file-io\\Resources\\out.txt"))
        ) {
            String context = null;
            while ((context = bufferedReader.readLine()) != null) {
                textSet.add(context);
            }
            for (String s : textSet) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
