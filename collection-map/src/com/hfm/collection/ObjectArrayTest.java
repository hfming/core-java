package com.hfm.collection;

import com.hfm.entity.Student;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 集合引入 - 对象数组
 * @date 2020-04-23 17:55
 */
public class ObjectArrayTest {
    public static void main(String[] args) {
        //创建学生数组
        Student[] students = new Student[3];
        //创建学生对象
        Student s1 = new Student("曹操", 40);
        Student s2 = new Student("刘备", 35);
        Student s3 = new Student("孙权", 30);
        //把学生对象作为元素赋值给学生数组
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        //遍历学生数组
        for (int x = 0; x < students.length; x++) {
            Student s = students[x];
            System.out.println(s.getName() + "‐‐‐" + s.getAge());
        }
    }
}
