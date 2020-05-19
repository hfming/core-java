package com.hfm.originalproject.bank.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 客户实体类
 * @date 2020-05-17 12:42
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = -9209180111501316107L;
    /**
     * 姓
     */
    private String firstName;
    /**
     * 名
     */
    private String lastName;
    /**
     * 银行账户
     * 可能有多张银行卡，一张银行卡对应一个银行账户
     * 默认集合长度为10
     */
    private ArrayList<Account> accounts = new ArrayList<>(10);

    /**
     * 构造函数
     *
     * @param firstName
     * @param lastName
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getAccounts(), customer.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAccounts());
    }
}
