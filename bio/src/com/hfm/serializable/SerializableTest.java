package com.hfm.serializable;

import com.hfm.entity.StudentNoSerializable;
import com.hfm.entity.StudentSerializable;

import java.io.*;
import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-27 16:05
 */
public class SerializableTest {
    public static void main(String[] args) {
        // 实现 Serializable 接口的对象
        // 创建集合对象，用于存储学生类对象
        ArrayList<StudentSerializable> students = new ArrayList<>();
        students.add(new StudentSerializable(1, "hfm", 24));
        students.add(new StudentSerializable(2, "csc", 22));
        students.add(new StudentSerializable(3, "hbgfm", 28));
        students.add(new StudentSerializable(4, "uu", 27));
        /**
         *  序列化
         */
        // JDk 7 自动关闭输出流
        try (
                // 创建对象输出流，将数据写入student文件
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file-io\\Resources\\students"))
        ) {
            objectOutputStream.writeObject(students);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /**
         * 反序列化
         */
        // JDk 7 自动关闭输出流
        try (
                // 创建对象输入流，将数据从硬盘读出
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file-io\\Resources\\students"))
        ) {
            // 将读出的对象赋值给ArrayList 集合
            ArrayList arrayList = (ArrayList) objectInputStream.readObject();

            // 遍历集合，打印学生对象
            for (Object o : arrayList) {
                System.out.println(o);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        /**
         *   没有实现 Serializable 接口的对象
         */
        // 创建集合对象，用于存储学生类对象
        ArrayList<StudentNoSerializable> students2 = new ArrayList<>();
        students2.add(new StudentNoSerializable(1, "hfm", 24));
        students2.add(new StudentNoSerializable(2, "csc", 22));
        students2.add(new StudentNoSerializable(3, "hbgfm", 28));
        students2.add(new StudentNoSerializable(4, "uu", 27));
        /**
         *     序列化
         */
        // JDk 7 自动关闭输出流
        try (
                // 创建对象输出流，将数据写入student文件
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("collection-map\\students"))
        ) {
            // Exception in thread "main" java.io.NotSerializableException: com.hfm.entity.StudentNoSerializable
            objectOutputStream2.writeObject(students2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
