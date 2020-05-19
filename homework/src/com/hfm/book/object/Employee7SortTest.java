package com.hfm.book.object;

import java.util.*;

/**
 * This program demonstrates the use of the Comparable interface.
 *
 * @author Cay Horstmann
 * @version 1.30 2004-02-27
 */
public class Employee7SortTest {
    public static void main(String[] args) {
        var staff = new Employee7[3];

        staff[0] = new Employee7("Harry Hacker", 35000);
        staff[1] = new Employee7("Carl Cracker", 75000);
        staff[2] = new Employee7("Tony Tester", 38000);

        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee7 e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
