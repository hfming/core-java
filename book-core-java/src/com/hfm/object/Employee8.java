package com.hfm.object;

// the classes in this file are part of this package

import java.time.*;

// import statements come after the package statement

/**
 * @author Cay Horstmann
 * @version 1.11 2015-05-08
 */
public class Employee8 {
    public double salary;
    private String name;
    private LocalDate hireDay;

    public Employee8(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
