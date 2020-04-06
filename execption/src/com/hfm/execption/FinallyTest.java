package com.hfm.execption;

import java.io.*;

/**
 * @author hfm
 * @version 1.01 2020-03-28 18:09
 * @date 2020/3/28
 */
public class FinallyTest {
    public static void main(String[] args) {
        File file= null;
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        // 捕获异常
        try {
            file = new File("E:/OneDrive - stu.cjlu.edu.cn/read.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String content = null;
            while ((content = bufferedReader.readLine()) != null) {
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取错误！");
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                throw new RuntimeException(e.getMessage());
            }finally{
                System.out.println("文件关闭成功！");
            }
        }
    }
}
