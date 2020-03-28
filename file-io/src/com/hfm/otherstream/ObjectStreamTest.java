package com.hfm.otherstream;

import java.io.*;

/**
 * 对象流
 * @author hfm
 */
public class ObjectStreamTest {

	public static void main(String[] args) {
		File fileOutput = new File("src/com/edu/cjlu/hfm/otherstream/Person.txt");
		ObjectOutputStreamFTest(fileOutput);
		ObjectInputStreamTest(fileOutput);
	}
	/**
	 * 对象输入，储存到本地，持久化储存
	 * @param fileOutput
	 */
	public static void ObjectOutputStreamFTest(File fileOutput) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		Person person = new Person(1, "hfm", "330327");
		try {
			fileOutputStream = new FileOutputStream(fileOutput);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(person);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	/**
	 *  反序列化，读取硬盘中的对象进到内存中
	 * @param fileInput
	 */
	public static void ObjectInputStreamTest(File fileInput) {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileInput);
			objectInputStream = new ObjectInputStream(fileInputStream);
			Person person = (Person) objectInputStream.readObject();
			System.out.println(person.toString());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
