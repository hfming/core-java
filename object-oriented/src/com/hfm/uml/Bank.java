package com.hfm.uml;

import java.util.ArrayList;

/**
 * @author hfm
 * @version 1.01 2020-04-11 17:02
 * @date 2020/4/11
 */
public class Bank {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    static int numOfCustomer = 0;

    public Bank() {

    }

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Bank.numOfCustomer++;
        customers.add(customer);
    }

    public static int getNumOfCustomer() {
        return numOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers.get(index-1);
    }
}
