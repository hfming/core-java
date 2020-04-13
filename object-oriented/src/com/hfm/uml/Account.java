package com.hfm.uml;

/**
 * UML account类
 *
 * @author hfm
 * @version 1.01 2020-04-11 16:49
 * @date 2020/4/11
 */
public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 存款方法
     *
     * @param balance
     */
    public void doposit(double balance) {
        this.balance += balance;
        System.out.println("存款成功，现有" + this.balance);
    }

    /**
     * 提款方法
     *
     * @param balance
     */
    public void withdraw(double balance) {
        if (this.balance < balance) {
            System.out.println("提款失败，现有" + this.balance);
        } else {
            this.balance -= balance;
            System.out.println("提款成功，现有" + this.balance);
        }
    }
}
