package com.hfm.bufferstream;

import java.io.*;

public class CopyImage {

	public static void main(String[] args) {
		File fileInput = new File("src/com/edu/cjlu/hfm/bufferstream/IMG_1.jpg");
		File fileOutput = new File("src/com/edu/cjlu/hfm/bufferstream/IMG_2.jpg");
		copyImageByByteStream(fileInput, fileOutput);
	}

	private static void copyImageByByteStream(File fileInput, File fileOutput) {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			fileInputStream = new FileInputStream(fileInput);
			fileOutputStream = new FileOutputStream(fileOutput);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			int length = 0;
			while ((length = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(length);
			}
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				fileInputStream.close();
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
}
