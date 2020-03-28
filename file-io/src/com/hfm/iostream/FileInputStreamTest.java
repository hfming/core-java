package com.hfm.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {

	}

	// 方式四：使用循环配合缓冲数组读取,首选方法
	public static void read4() throws IOException {
		// 找到目标文件
		File file = new File("F:\\a.txt");
		// 建立数据的通道
		FileInputStream fileInputStream = new FileInputStream(file);
		// 读取数据
		byte[] buf = new byte[1024]; // 缓冲字节数组的长度一般都是1024的倍数。
		int length = 0; // 记录本次读取的自己个数。
		while ((length = fileInputStream.read(buf)) != -1) {
			System.out.print(new String(buf, 0, length));
		}
		// 关闭资源(释放资源文件)
		fileInputStream.close();
	}

	// 方式3：使用（缓冲数组）字节数组读取 ， 无法完整读取一个文件的数据 12G
	public static void read3() throws IOException {
		// 找到目标文件
		File file = new File("F:\\a.txt");
		// 建立数据的通道
		FileInputStream fileInputStream = new FileInputStream(file);
		// 创建一个字节数组，读取文件数据
		byte[] buf = new byte[10];
		int length = fileInputStream.read(buf); // read(byte[] buf)
												// 先把读取到的数据存储到字节数组中，然后返回的是本次读取到字节数。
		System.out.println("读取到的内容：" + new String(buf, 0, length));
	}

	// 方式2： 每次读取一个字节的数据，可以读取完整文件数据。 340
	public static void read2() throws IOException {
		long startTime = System.currentTimeMillis();
		// 第一步：找到目标文件
		File file = new File("F:\\美女\\1.jpg");
		// 第二步： 建立数据通道
		FileInputStream fileInputStream = new FileInputStream(file);
		// 第三步：读取文件的数据
		int content = 0; // 用于保存读取到的数据
		while ((content = fileInputStream.read()) != -1) { // read()
															// 方法如果读取了文件的末尾则返回-1表示。
			System.out.print((char) content);
		}
		// 关闭资源
		fileInputStream.close();
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间:" + (endTime - startTime));
	}

	// 方式一： 没法读取完整一个文件的数据
	public static void read1() throws IOException {
		// 第一步： 找到目标文件对象
		File file = new File("f:\\a.txt");
		// 第二步： 建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		// 第三步： 读取文件数据
		int content = fileInputStream.read(); // 返回 的是读取的字节数据，每次只会读取一个字节。
		System.out.println("读到的内容：" + (char) content);
		// 第四步：关闭资源(释放资源文件)
		fileInputStream.close();
	}
}
