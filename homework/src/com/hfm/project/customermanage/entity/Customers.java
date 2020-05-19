package com.hfm.project.customermanage.entity;

import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 客户群体类：用于对客户的增删查改，ArrayList 集合方式
 * @date 2020-04-17 17:28
 */
public class Customers {
    /**
     * 存储客户容器
     */
    private ArrayList<Customer> customers;

    /**
     * 构造函数
     */
    public Customers() {
        this.customers = new ArrayList<>();
    }

    /**
     * 添加客户
     *
     * @param customer 输入 customer
     * @return 返回 boolean
     */
    public boolean addCustomer(Customer customer) {
        if (this.customers.contains(customer)) {
            return false;
        }
        customers.add(customer);
        return true;
    }

    /**
     * 删除客户
     *
     * @param index 输入 ID
     * @return 返回 boolean
     */
    public boolean delectCustomer(int index) {
        this.customers.remove(customers.get(index - 1));
        return true;
    }

    /**
     * 查找用户
     *
     * @param index ID
     * @return 返回 boolean
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= this.customers.size()) {
            return null;
        }
        return customers.get(index - 1);
    }

    /**
     * 打印所有客户
     */
    public boolean getAllCustomer() {
        System.out.println("ID\t姓名\t性别\t年龄\t电话号码\t邮箱");
        int count = 0;
        for (Customer customer : customers) {
            System.out.println(++count + "\t" + customer.getName() + "\t\t"
                    + customer.getSex().getSex() + "\t\t" + customer.getAge() + "\t\t"
                    + customer.getPhoneNumber() + "\t" + customer.getEmail());
        }
        return true;
    }

    /**
     * 获取客户数目
     *
     * @return 返回 boolean
     */
    public int getSize() {
        return customers.size();
    }
}
