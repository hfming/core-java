package com.hfming.abstractkeywords;

/**
 * 抽象类的使用
 * @author hfm
 * @version 1.01 2019-10-19
 */
public class Student extends Person {
    private String major;

    /**
     * @param n the student's name
     * @param m the student's major
     */
    public Student(String n, String m) {
        // pass n to superclass constructor
        super(n);
        major = m;
    }

    public String getDescription() {
        return "a student majoring in " + major;
    }
}
