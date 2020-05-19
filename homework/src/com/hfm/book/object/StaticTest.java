package com.hfm.book.object;

/**
 * 该程序演示了静态方法。
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class StaticTest {
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee3[] staff = new Employee3[3];

        staff[0] = new Employee3("Tom", 40000);
        staff[1] = new Employee3("Dick", 60000);
        staff[2] = new Employee3("Harry", 65000);

        // print out information about all Employee objects
        for (Employee3 e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }

        // calls static method
        int n = Employee3.getNextId();
        System.out.println("Next available id=" + n);
    }
}

class Employee3 {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employee3(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        // set id to next available id
        id = nextId;
        nextId++;
    }

    public static int getNextId() {
        // returns static field
        return nextId;
    }

    // unit test
    public static void main(String[] args) {
        var e = new Employee3("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
