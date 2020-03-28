package com.hfm.file;

import java.io.*;

public class IOTest {

	public static void main(String[] args) {
		File file = new File("src/com/edu/cjlu/hfm/review/Review_1.txt");
		System.out.println(file.getName());
/*		// 子节流
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		// 字节；缓冲流
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;*/

		// 字符流
		FileReader fileReader = null;
		//FileWriter fileWriter = null;
		// 字符缓冲流
		BufferedReader bufferedReader = null;
		//BufferedWriter bufferedWriter = null;
		try {
/*			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(file);
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);

			int length = -1;
			byte[] b = new byte[1024];
			while ((length = bufferedInputStream.read(b)) != -1) {
				System.out.println(length);
				System.out.println(new String(b, 0, length));
			}*/

			fileReader = new FileReader(file);
			//fileWriter = new FileWriter(file);
			bufferedReader = new BufferedReader(fileReader);
			//bufferedWriter = new BufferedWriter(fileWriter);
			String line = "";
			line = bufferedReader.readLine();
					
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
