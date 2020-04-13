package com.hfm.uml;

/**
 * @author hfm
 * @version 1.01 2020-04-11 16:59
 * @date 2020/4/11
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public  Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
