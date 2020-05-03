package com.hfm.cloneable;

import com.hfm.entity.Book;
import com.hfm.entity.StudentDeepClone;
import com.hfm.entity.StudentShallowClone;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-27 17:11
 */
public class DeepCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book(12, "<<Java 核心技术上>>", 46);
        Book book2 = new Book(11, "<<Java 核心技术下>>", 50);
        // 浅拷贝
        // 创建实现 cloneable接口的 StudetnCloneable 接口
        StudentShallowClone student1 = new StudentShallowClone(2, "fe", 89, book1);
        // 调用 clone 方法实现对 Student2 的 clone
        StudentShallowClone studentShallowClone =(StudentShallowClone) student1.clone();
        // 打印输出 clone 对象
        System.out.println(studentShallowClone);

        // 改变原数据中的book 对象
        student1.getBook().setPrice(56);
        // 打印输出 clone 对象，book 对象也随着改变
        System.out.println(studentShallowClone);

        // 深克隆
        // 创建克隆对象
        StudentDeepClone student2 = new StudentDeepClone(3, "fehu", 23, book2);
        // 调用clone 方法拷贝对象
        StudentDeepClone studentDeepClone = (StudentDeepClone) student2.clone();
        // 调用输出克隆对象
        System.out.println(studentDeepClone);

        // 改变原数据中的book 对象
        student2.getBook().setPrice(56);
        // 打印输出克隆对象，克隆对象的book 没有发生改变
        System.out.println(studentDeepClone);
    }
}
