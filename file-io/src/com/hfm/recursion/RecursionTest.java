package com.hfm.recursion;

import java.io.File;

/**
 * 递归调用
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(factorial(3));

        File file = new File("file-io\\");
        // 列出一个文件夹中的所有子孙文件与文件夹。
//		listAllFile(file);
//		// 列出指定目录中所有的子孙文件与子孙目录名，要求名称前面要有相应数量的空格：第一级前面有0个，第二级前面有1个，第三级前面有2个.以此类推。
//		listAllFile2(file, "\t");
        listFiles3(file, "|--");

        printDir(file);
    }

    /**
     * 阶乘
     *
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    /**
     * 需求1： 列出一个文件夹中的所有子孙文件与文件夹。
     *
     * @param file
     */
    public static void listAllFile(File file) {
        if (file.isFile()) {
            System.out.println(file.getName());
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listAllFile(f);
            }
        }
    }

    /**
     * 分析：多级目录的打印，就是当目录的嵌套。遍历之前，无从知道到底有多少级目录，所以我们还是要使用递归实现
     *
     * @param dir
     */
    public static void printDir(File dir) {
        // 获取子文件和目录
        File[] files = dir.listFiles();
        // 循环打印
        /**
         判断:
         当是文件时,打印绝对路径.
         当是目录时,继续调用打印目录的方法,形成递归调用.
         */
        for (File file : files) {
            // 判断
            if (file.isFile()) {
                // 是文件,输出文件绝对路径
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                // 是目录,输出目录绝对路径
                // 继续遍历,调用printDir,形成递归
                System.out.println("目录:" + file.getAbsolutePath());
                printDir(file);
            }
        }
    }

    /**
     * 需求2:列出指定目录中所有的子孙文件与子孙目录名，要求名称前面要有相应数量的空格：第一级前面有0个，第二级前面有1个，第三级前面有2个.以此类推。
     *
     * @param
     */
    public static void listAllFile2(File dir, String space) {
        // 找到文件夹中 的所有子文件与子目录
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(space + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(space + file.getName());
                listAllFile2(file, space + " ");
            }
        }
    }

    /**
     * 需求3 ：列出指定目录中所有的子孙文件与子孙目录名，要求要是树状结构，效果如下所示：
     * |--src
     * | |--cn
     * | | |--itcast
     * | | | |--a_helloworld 5
     * | | | | |--HelloWorld.java
     * | | | |--b_for
     * | | | | |--ForTest.java
     * | | | |--c_api
     * | | | | |--Student.java
     * |--bin
     * | |--cn
     * | | |--itcast
     * | | | |--i_exception
     * | | | | |--ExceptionTest.class
     * | | | |--h_linecount
     * | | | | |--LineCounter3.class
     * | | | | |--LineCounter2.class
     * | | | | |--LineCounter.class
     * |--lib
     * | |--commons-io.jar
     */
    public static void listFiles3(File dir, String space) {
        // 找到文件夹中 的所有子文件与子目录
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(space + file.getName());
            }
            if (file.isDirectory()) {
                System.out.println(space + file.getName());
                listFiles3(file, "| " + space);
            }
        }
    }
}
