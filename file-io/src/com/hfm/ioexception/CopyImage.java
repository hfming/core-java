package com.hfm.ioexception;

import java.io.*;

public class CopyImage {

	public static void main(String[] args) {
		File fileInput = new File("src/com/edu/cjlu/hfm/ioexception/IMG_1.jpg");
		File fileOutput = new File("src/com/edu/cjlu/hfm/ioexception/IMG_2.jpg");
		copyImageByByteStream(fileInput, fileOutput);
	}

	private static void copyImageByByteStream(File fileInput, File fileOutput) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(fileInput);
			fileOutputStream = new FileOutputStream(fileOutput);
			int length = 0;
			byte[] b = new byte[1024];
			while ((length = fileInputStream.read(b)) != -1) {
				fileOutputStream.write(b, 0, length);
				fileOutputStream.flush();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e); //抛出运行时异常，可以不处理
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				fileOutputStream.close(); //先开后关,后开先关
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e); 
				}
			}
		}
	}
}
