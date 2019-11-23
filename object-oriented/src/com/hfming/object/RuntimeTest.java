package com.hfming.object;

import java.io.IOException;

/**
 * Runtime测试
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class RuntimeTest {

    public static void main(String[] args) throws IOException {
        System.out.println("试图使用的最大内存量:" + Runtime.getRuntime().maxMemory());
        System.out.println("Java 虚拟机中的内存总量：" + Runtime.getRuntime().totalMemory());
        System.out.println("当前空闲的内存：" + Runtime.getRuntime().freeMemory());
		//运行指定路径下的程序,创建一个线程
        Runtime.getRuntime().exec("C:\\Windows\\notepad.exe");
        Runtime.getRuntime().gc();
    }
}
