package com.hfm.entity;

/**
 * A minimalist employee class for testing purposes.
 */
public class Employee2 {
    private String name;
    private double salary;

    /**
     * Constructs an employee with $0 salary.
     *
     * @param n the employee name
     */
    public Employee2(String n) {
        name = n;
        salary = 0;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", salary=" + salary + "]";
    }
}
