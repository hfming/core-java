package com.hfm.collection;

import com.hfm.entity.Student;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 集合引入 - 对象数组
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 * 2.数组存储元素的特点
 *     >一旦初始化以后，其长度就确定了。
 *     >数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *    比如：string[]arr；int[]arr1；Object[]arr2；
 * 3.教组在存储多个数据方面的缺点：
 *     >一旦初始化以后，其长度就不可修改。
 *     >数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *     >获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *     >数组存储数帮的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
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
