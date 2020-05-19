package com.hfm.otherstream;

import com.hfm.entity.Person;

import java.io.*;

/**
 * 对象流
 *
 * @author hfm
 */
public class ObjectStreamTest {
    public static void main(String[] args) {
        File fileOutput = new File("file-io\\Resources\\Person.txt");
        ObjectOutputStreamFTest(fileOutput);
        ObjectInputStreamTest(fileOutput);
    }

    /**
     * 对象输入，储存到本地，持久化储存
     *
     * @param fileOutput
     */
    public static void ObjectOutputStreamFTest(File fileOutput) {
        Person person = new Person(1, "hfm", "330327");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            // 写出对象
            objectOutputStream.writeObject(person);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化，读取硬盘中的对象进到内存中
     *
     * @param fileInput
     */
    public static void ObjectInputStreamTest(File fileInput) {
        try (
                FileInputStream fileInputStream = new FileInputStream(fileInput);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            // 获取对象
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
