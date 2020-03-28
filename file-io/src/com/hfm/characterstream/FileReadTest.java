package com.hfm.characterstream;

import java.io.*;

public class FileReadTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		readTest1();

	}

	// 使用缓冲输入字符流读取。
	public static void readTest1() throws FileNotFoundException, IOException {
		File file = new File("src/com/edu/cjlu/hfm/characterstream/CharacterStream_4.txt");
		// 建立文件的输入通道。
		FileReader fileReader = new FileReader(file);
		// 读取文件的数据
		int line = -1;
/*		while ((line = fileReader.read()) != -1) {
			System.out.print((char) line);// 每次只会读取一个字符数据，建议使用缓冲输入字符流
		}*/
		System.out.println("============================");
		char [] c = new char[1024];
		while((line = fileReader.read(c))!=-1){
			System.out.println(new String(c,0,line));
		}
		// 关闭资源
		fileReader.close();
	}

	/**
	 * 使用缓冲输入字符流读取。
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readTest2() throws FileNotFoundException, IOException {
		File file = new File("src/com/edu/cjlu/hfm/characterstream/CharacterStream_4.txt");
		// 建立文件的输入通道。
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		// 读取文件的数据
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);// 每次只会读取一个字符数据，建议使用缓冲输入字符流
		}
		// 关闭资源
		bufferedReader.close();
	}

	/**
	 * 自己实现一个 readLine 方法。
	 * @param fileReader
	 * @return
	 * @throws IOException
	 */
	public static String myReadLine(FileReader fileReader) throws IOException {
		StringBuilder sb = new StringBuilder();
		int content = 0;
		while ((content = fileReader.read()) != -1) {
			if (content == '\r') {
				continue;
			} else if (content == '\n') {
				return sb.toString();
			} else {
				// 正常的字符
				sb.append((char) content);
			}
		}
		return null;
	}
}
