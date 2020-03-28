package com.hfm.characterstream;

import java.io.*;

public class CharacterStreamTest {
	/**
	 * 拷贝文件应该使用字节流，读取文件可以使用字符流
	 * @param args
	 */
	public static void main(String[] args) {
		File fileInput = new File("src/com/edu/cjlu/hfm/characterstream/IMG_1.jpg");
		File fileOutput = new File("src/com/edu/cjlu/hfm/characterstream/IMG_2.jpg");
		copyImage(fileInput, fileOutput);
		copyImageByBuffer(fileInput, fileOutput);
	}

	/**
	 * 字符流拷贝文件 复制的文件不能打开
	 * 
	 * @param file
	 */
	public static void copyImage(File fileInput, File fileOutput) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		char[] ch = new char[1024];
		int length = -1;
		try {
			fileReader = new FileReader(fileInput);
			fileWriter = new FileWriter(fileOutput);
			while ((length = fileReader.read(ch)) != -1) {
				fileWriter.write(ch, 0, length);
			}
			fileWriter.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					fileWriter.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 使用缓冲字符流拷贝文件
	 * 拷贝的文件也不能正常读取
	 * @param fileInput
	 * @param fileOutput
	 */
	public static void copyImageByBuffer(File fileInput, File fileOutput) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		String content = null;
		try {
			fileReader = new FileReader(fileInput);
			fileWriter = new FileWriter(fileOutput);
			bufferedReader = new BufferedReader(fileReader);
			bufferedWriter = new BufferedWriter(fileWriter);
			while ((content = bufferedReader.readLine()) != null) {
				bufferedWriter.write(content);
			}
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
