package com.hfming.corejava;

/**
 * This program demonstrates static methods.
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-19
 */
public class Employee {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    // unit test
    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }

    public Employee(String n, double s) {
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
        id = nextId; // set id to next available id
        nextId++;
    }

    public static int getNextId() {
        return nextId; // returns static field
    }


}
