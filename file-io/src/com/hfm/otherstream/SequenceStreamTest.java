package com.hfm.otherstream;

import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Vector;

/**
 * 合并流(序列流)
 * @author hfm
 */
public class SequenceStreamTest {
	public static void main(String[] args) {
		File file1 = new File("1.txt");
		File file2 = new File("2.txt");
		File fileOutput = new File("合并.txt");
		FileInputStream fileInputStream1 = null;
		FileInputStream fileInputStream2 = null;
		SequenceInputStream sequenceInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream1 = new FileInputStream(file1);
			fileInputStream2 = new FileInputStream(file2);
			sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
			fileOutputStream = new FileOutputStream(fileOutput);
			int length = -1;
			byte[] b = new byte[1024];
			while ((length = sequenceInputStream.read(b)) != -1) {
				System.out.println(new String(b, 0, length));
				fileOutputStream.write(b, 0, length);
			}
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				sequenceInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	// 合并多个流
	public static void testSequenceInputStream() throws IOException {
		InputStream in1 = new FileInputStream("c:/a.txt");
		InputStream in2 = new FileInputStream("c:/b.txt");
		InputStream in3 = new FileInputStream("c:/c.txt");
		LinkedHashSet<InputStream> set = new LinkedHashSet<InputStream>();
		set.add(in1);
		set.add(in2);
		set.add(in3);
		final Iterator<InputStream> iter = set.iterator();
		// 传入一个迭代器对象，需要输入Enumeration，需要重写其方法，间接调用其方法，达到相同的效果
		SequenceInputStream sin = new SequenceInputStream(new Enumeration<InputStream>() {// 匿名内部类
			@Override
			public boolean hasMoreElements() {
				return iter.hasNext();
			}
			@Override
			public InputStream nextElement() {
				return iter.next();
			}
		});
		FileOutputStream out = new FileOutputStream("c:/z.txt");
		for (int b = -1; (b = sin.read()) != -1;) {
			out.write(b);
		}
		sin.close();
		out.close();
	}
	// 合并 mp3 文件
	public static void mergeFile() throws IOException {
		File dir = new File("f:\\music");
		File[] files = dir.listFiles(); // 获取到文件夹中的所有子文件
		// 创建一个 Vector 对象存储 FileInputStream 对象
		Vector<FileInputStream> vector = new Vector<FileInputStream>();
		// 遍历数组，
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().endsWith(".mp3")) {
				vector.add(new FileInputStream(files[i]));
			}
		}
		// 创建一个序列流对象
		SequenceInputStream inputStream = new SequenceInputStream(vector.elements());
		// 创建一个输出流对象
		FileOutputStream fileOutputStream = new FileOutputStream("f:\\晚风.mp3");
		// 边读边写
		byte[] buf = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(buf)) != -1) {
			fileOutputStream.write(buf, 0, length);
		}
		// 关闭资源
		fileOutputStream.close();
		inputStream.close();
	}
	// 切割 mp3
	public static void cutFile() throws IOException {
		File file = new File("F:\\美女\\1.mp3");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buf = new byte[1024 * 1024];
		int length = 0;
		int count = 1;
		while ((length = fileInputStream.read(buf)) != -1) {
			// 每读取一次，则生成一个文件
			FileOutputStream fileOutputStream = new FileOutputStream("F:\\music\\part" + count + ".mp3");
			// 把读取到的数据写出
			fileOutputStream.write(buf, 0, length);
			count++;
			// 关闭资源
			fileOutputStream.close();
		}
		// 关闭资源
		fileInputStream.close();
	}
}
