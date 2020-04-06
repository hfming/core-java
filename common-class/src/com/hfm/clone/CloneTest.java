package com.hfm.clone;

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.11 2018-03-16
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 浅克隆
        Employee1 from = new Employee1("John Q. Public", 50000);
        from.setHireDay(2000, 1, 1);

        Employee1 to = (Employee1) from.clone();
        to.raiseSalary(10);
        to.setHireDay(2002, 12, 31);

        System.out.println("from=" + from);
        System.out.println("to=" + to);

        // 深克隆
        var original = new Employee2("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);

        Employee2 copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);

        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}
