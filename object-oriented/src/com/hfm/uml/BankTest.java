package com.hfm.uml;

/**
 * @author hfm
 * @version 1.01 2020-04-11 17:12
 * @date 2020/4/11
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println(Bank.getNumOfCustomer());
        bank.addCustomer("黄", "福明");
        bank.getCustomer(1);
        System.out.println(Bank.getNumOfCustomer());
    }
}
