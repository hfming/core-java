package com.hfm.object;

/**
 * 使用测试SimpleStudent对象
 *
 * @author hfm
 * @version 1.01 2019-10-16
 */
public class SimpleStudentTest {
    public static void main(String[] args) {
        // 创建一个SimpleStudent对象，栈内存中创建应用类型变量的局部变量，堆内存中创建以new关键字创建的对象
        SimpleStudent student1 = new SimpleStudent();
        student1.study();

        // 创建一个SimpleStudent对象，栈内存中创建新的应用类型变量的局部变量，堆内存中创建新的以new关键字创建的对象
        SimpleStudent student2 = new SimpleStudent();
        student2.study();

        // 创建一个SimpleStudent引用类型变量，并把student1的值赋值给student，传递的是内存地址值
        SimpleStudent student = student1;

        // 调用方法返回对象
        getSimpleStudent();

        // 调用方法传入对象
        giveSimpleStudent(student);

        // 创建对象数组
        SimpleStudent[] students = new SimpleStudent[20];
        // 对象数组初始化
        for (int i = 0; i < students.length; i++) {
            students[i] = new SimpleStudent();
        }
    }

    /**
     * 创建方法传入对象
     *
     * @param student
     */
    private static void giveSimpleStudent(SimpleStudent student) {
        System.out.println(student.name);
        System.out.println(student.age);
        student.study();
    }

    /**
     * 创建方法返回SimpleStudent对象
     *
     * @return
     */
    public static SimpleStudent getSimpleStudent() {
        SimpleStudent student = new SimpleStudent();
        student.name = "hfm";
        student.age = 25;
        student.study();
        return student;
    }
}
