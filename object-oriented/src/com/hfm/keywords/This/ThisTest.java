package com.hfm.keywords.This;

/**
 * this 关键字的使用
 *
 * @author hfm
 * @version 1.01 2019-10-17
 */
public class ThisTest {
    public static void main(String[] args) {
        Baby baby = new Baby("000343", "hfm");
        baby.cry();

        Student student = new Student(1, "hfm", 24);
        System.out.println(student);
    }
}
