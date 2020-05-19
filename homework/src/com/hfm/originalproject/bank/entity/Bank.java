package com.hfm.originalproject.bank.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 银行实体类 单例设计模式
 * @date 2020-05-17 12:45
 */
public class Bank implements Serializable {
    private static final long serialVersionUID = 8519764702043853035L;
    /**
     * 存储账户容器
     */
    private ArrayList<Customer> customers;

    /**
     * 创建本类私有的对象
     */
    private static final Bank bank = new Bank();

    /**
     * 单例设计模式
     * 创建初始容量为 1000 的集合容器
     */
    private Bank() {
        this.customers = new ArrayList<Customer>(1000);
    }

    /**
     * 提供公共给方法返回本类唯一对象
     *
     * @return
     */
    public static Bank getBank() {
        return bank;
    }

    /**
     * 添加用户
     *
     * @param firstName 姓
     * @param lastName  名
     * @return 是否添加成功
     */
    public boolean addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        if (customers.contains(customer)) {
            return false;
        }
        customers.add(customer);
        return true;
    }

    /**
     * 添加 getNumOfCustomers 访问方法，它返回 numberofCustomers 属性值。
     *
     * @return
     */
    public int getNumberOfCustomer() {
        return this.customers.size();
    }

    /**
     * 添加 getCustomer方法。它返回与给出的index参数相关的客户。
     *
     * @param id
     * @return
     */
    public Customer getCustomerByID(int id) {
        if (id <= 0 || id > getNumberOfCustomer()) {
            return null;
        }
        return customers.get(id - 1);
    }
}
