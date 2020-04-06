package com.hfm.keywords.Static;

/**
 * @author hfm
 * @version 1.01 2020-04-02 18:56
 * @date 2020/4/2
 */
public class StuDemo {
    public static void main(String[] args) {
        Student s1 = new Student("张三" , 23);
        Student s2 = new Student("李四" , 24);
        Student s3 = new Student("王五" , 25);
        Student s4 = new Student("赵六" , 26);
        s1.show(); // Student : name=张三, age=23, sid=1
        s2.show(); // Student : name=李四, age=24, sid=2
        s3.show(); // Student : name=王五, age=25, sid=3
        s4.show(); // Student : name=赵六, age=26, sid=4
    }
}
