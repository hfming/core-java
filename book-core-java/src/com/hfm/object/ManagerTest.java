package com.hfm.object;

/**
 * This program demonstrates inheritance.
 *
 * @author Cay Horstmann
 * @version 1.21 2004-02-21
 */
public class ManagerTest {
    public static void main(String[] args) {
        // construct a Manager object
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        var staff = new Employee5[3];

        // fill the staff array with Manager and Employee objects

        staff[0] = boss;
        staff[1] = new Employee5("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee5("Tommy Tester", 40000, 1990, 3, 15);

        // print out information about all Employee objects
        for (Employee5 e : staff) {

            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
