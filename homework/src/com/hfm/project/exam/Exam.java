package com.hfm.project.exam;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-17 14:25
 */
public class Exam {
    public static void main(String[] args) {
        System.out.println("========单击考试系统========");
        System.out.println("n:下一题\tp:上一题");
        System.out.println("========考试正式开始========");
        new ItemService("homework/Resources/answer.dat").readAnswer();
        // new  ExamView().testExam();
    }
}
