package com.hfm.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyPhoto {

	public static void main(String[] args) throws Exception {
		// 找到目标文件
		File inFile = new File("F:\\美女\\1.mp3");
		File outFile = new File("E:\\拷贝.mp3");
		// 建立数据通道
		FileInputStream fileInputStream = new FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		// 建立缓冲字节数组，边读边写
		byte[] buf = new byte[1024];
		int length = 0; // 用于记录每次读取的字节个数
		while ((length = fileInputStream.read(buf)) != -1) { // 700 300
			fileOutputStream.write(buf, 0, length);//读多少写多少
		}
		// 关闭资源(关闭资源的原则：先开后关，后开先关)
		fileOutputStream.close();
		fileInputStream.close();
	}
}
