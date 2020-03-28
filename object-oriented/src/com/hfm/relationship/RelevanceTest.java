package com.hfm.relationship;

/**
 * 类与类之间的关系
 * 关联 Demo
 *
 * @author hfm
 * @version 1.01 2020-03-26 19:08
 * @date 2020/3/26
 */
public class RelevanceTest {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("hfm");
        students[1] = new Student("tft");
        students[2] = new Student("AOA");
        students[3] = new Student("ctc");
        Teacher teacher = new Teacher("hfm", students);
        teacher.giveClass();
    }
}

/**
 * 实体类
 * 教师
 */
class Teacher {
    private String name;
    /**
     * 老师可以关联多个学生
     */
    private Student[] students;

    public Teacher(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Teacher() {
    }

    public void giveClass() {
        for (Student student : this.students) {
            student.study();
        }
    }
}

/**
 * 实体类 学生
 */
class Student {
    private String name;
    /**
     * 学生关联一个老师
     */
    private Teacher teacher;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public void study() {
        System.out.println(this.name + "学习！");
    }
}