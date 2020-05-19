package com.hfm.book.object;

import com.hfm.entity.Employee;

import static java.lang.System.out;

// the Employee class is defined in that package

/**
 * 该程序演示了程序包的使用。
 *
 * @author Cay Horstmann
 * @version 1.11 2004-02-19
 */
public class PackageTest {
    public static void main(String[] args) {
        // because of the import statement, we don't have to use
        // com.horstmann.corejava.Employee here
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
