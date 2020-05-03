package com.hfm.teammanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 雇员父类
 * @date 2020-04-18 11:22
 */
public class Employee {
    /**
     * @Description 人员编号
     */
    private int id;
    /**
     * @Description 姓名
     */
    private String name;
    /**
     * @Description 年龄
     */
    private int age;
    /**
     * @Description 资薪
     */
    private double salary;

    /**
     * 构造函数
     *
     * @param id     ID
     * @param name   姓名
     * @param age    年龄
     * @param salary 薪水
     */
    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    protected String getDetails() {
        return id + "\t" + name + "\t" + age+ "\t\t" +salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSaraly() {
        return salary;
    }

    public void setSaraly(double saraly) {
        this.salary = saraly;
    }
}
