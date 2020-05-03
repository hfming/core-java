package com.hfm.customermanage.entity;

import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 客户实体类
 * @date 2020-04-17 17:13
 */
public class Customer {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Sex sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 电话号码
     */
    private String phoneNumber;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 构造函数
     */
    public Customer(String name, Sex sex, int age, String phoneNumber, String email) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(name, customer.name) &&
                sex == customer.sex &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, phoneNumber, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
