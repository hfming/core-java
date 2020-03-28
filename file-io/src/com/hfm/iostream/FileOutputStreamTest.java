package com.hfm.iostream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
	}
	// 方式二： 先把数据转成字节数组然后再写出。
	public static void write2() throws IOException {
		// 找到目标文件
		File file = new File("F:\\a.txt");
		// 建立数据的输出通道
		FileOutputStream fileOutputStream = new FileOutputStream(file, true); // 第二个参数为true时写入文件数据就是以追加的形式写入的
		// 准备数据， 把数据写出
		String str = "\r\nhello world";
		// 把字符串转成字节数组
		byte[] buf = str.getBytes();
		// 把字节数组写出
		fileOutputStream.write(buf);
		// 关闭资源
		fileOutputStream.close();
	}

	// 方式一： 每次只能写 一个字节的数据 。
	public static void write1() throws IOException {
		// 找到目标文件
		File file = new File("f:\\a.txt");
		// 建立数据的输出通道
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		// 把数据写出
		fileOutputStream.write('h');
		fileOutputStream.write('e');
		fileOutputStream.write('l');
		fileOutputStream.write('l');
		fileOutputStream.write('o');
		// 关闭资源
		fileOutputStream.close();
	}
}
